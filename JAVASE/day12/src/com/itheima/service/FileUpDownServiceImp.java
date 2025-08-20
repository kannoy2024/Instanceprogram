package com.itheima.service;

import com.itheima.exception.BusinessException;
import com.itheima.util.AgreementUtil;
import com.itheima.util.IOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;

/*
    协议定义:   协议+数据
    第一行是协议，第二行开始就是数据
 */
public class FileUpDownServiceImp implements Runnable, FileUpDownService {
    private static final Logger logger = LoggerFactory.getLogger(FileUpDownServiceImp.class);
    private final ResourceBundle bundle;
    private final File rootDir;
    private Socket socket;

    public FileUpDownServiceImp(Socket socket) {
        this.socket = socket;
        //1 读取配置文件中的端口，根目录等配置信息
        bundle = ResourceBundle.getBundle("yunpan");
        //根目录  rootDir = D:\\img
        rootDir = new File(bundle.getString("rootDir"));
        if (rootDir.isFile()) {
            throw new BusinessException("根目录路径与已存在文件冲突");
        } else if (!rootDir.exists() && !rootDir.mkdirs()) {
            throw new BusinessException("根目录创建失败，请检查配置路径是否正确");
        }
    }

    @Override
    public void run() {
        try (Socket socket = this.socket;
             InputStream netIn = socket.getInputStream();
             OutputStream netOut = socket.getOutputStream();
        ) {
            logger.info("客户端连接: {}", socket.getRemoteSocketAddress());
            // 读协议
            final String agreement = AgreementUtil.receiveAgreement(netIn);
            // System.out.println("接收客户端数据：" + agreement);
            logger.debug("收到协议: {}", agreement);
            // 解析字符串
            String type = AgreementUtil.getType(agreement);
            // System.out.println("解析字符串的数据类型:" + type);
            switch (type) {
                case "SCAN"://客户端要浏览
                    scanDirectory(agreement, netIn, netOut);
                    logger.info("处理查询请求");
                    break;
                case "DOWNLOAD"://客户端要下载
                    downloadFile(agreement, netIn, netOut);
                    logger.info("处理下载请求");
                    break;
                case "UPLOAD"://客户端要上传
                    uploadFile(agreement, netIn, netOut);
                    logger.info("处理上传请求");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 浏览目录
    @Override
    public void scanDirectory(String agreement, InputStream netIn, OutputStream netOut) throws IOException {
        //响应客户端使用
        //获取客户端想要浏览的目录
        String fileName = AgreementUtil.getFileName(agreement);// root
        //root是提供给客户端的虚拟路径，转换为服务端的真实路径
        String fileDir = fileName.replace("root", rootDir.toString());
        File dir = new File(fileDir);

        if (dir.isFile()) {
            // 封装协议
            String s = AgreementUtil.getAgreement("SCAN", null, "FAILED", "目录不存在.只能浏览当前子目录");
            // 发送协议
            AgreementUtil.sendAgreement(netOut, s);
        } else {
            // 封装协议
            String s = AgreementUtil.getAgreement("SCAN", fileDir, "OK", null);
            AgreementUtil.sendAgreement(netOut, s);

            //把具体数据随后发送
            //把文件数据按照："文件类型 名称"   发送，每一个子文件一行
            OutputStreamWriter osw = new OutputStreamWriter(netOut);
            File[] children = dir.listFiles();

            for (File child : children) {
                String fileType = child.isFile() ? "文件" : "目录";
                osw.write(fileType + " " + child.getName() + "\r\n");//每个文件一行
            }
            //刷新数据
            osw.flush();
        }
    }

    // 文件上传功能（服务端修正）
    @Override
    public void uploadFile(String agreement, InputStream netIn, OutputStream netOut) throws IOException {
        String fileName = AgreementUtil.getFileName(agreement);
        String filePath = fileName.replace("root", rootDir.toString());
        File targetFile = new File(filePath);

        // 检查文件是否存在
        if (targetFile.exists()) {
            String response = AgreementUtil.getAgreement("UPLOAD", fileName, "FAILED", "文件已存在");
            logger.info("文件已经存在");
            AgreementUtil.sendAgreement(netOut, response);
            return;
        }
        logger.info("要上传的文件不存在");
        // 检查父目录
        File parentDir = targetFile.getParentFile();
        if (!parentDir.exists() && !parentDir.mkdirs()) {
            String response = AgreementUtil.getAgreement("UPLOAD", fileName, "FAILED", "无法创建目录");
            logger.info("无法创建目录");
            AgreementUtil.sendAgreement(netOut, response);
            return;
        }
        logger.info("目录创建成功");
        // 发送READY协议（准备接收）
        String readyResponse = AgreementUtil.getAgreement("UPLOAD", fileName, "READY", "准备接收文件");
        AgreementUtil.sendAgreement(netOut, readyResponse);
        logger.info("准备接受文件");
        // 接收文件数据
        try (FileOutputStream fileOut = new FileOutputStream(targetFile)) {
            // 接收文件数据
            IOUtil.copy(netIn, fileOut);

            fileOut.flush();
            logger.info("文件接收完成，准备发送成功响应");

            // 发送最终OK协议
            String successResponse = AgreementUtil.getAgreement("UPLOAD", fileName, "OK", "文件上传成功");
            AgreementUtil.sendAgreement(netOut, successResponse);
            logger.info("已发送成功响应");
        } catch (IOException e) {
            if (targetFile.exists()) targetFile.delete();
            String errorResponse = AgreementUtil.getAgreement("UPLOAD", fileName, "FAILED", "上传失败: " + e.getMessage());
            AgreementUtil.sendAgreement(netOut, errorResponse);
            throw e;
        }
    }

    // 文件下载功能
    @Override
    public void downloadFile(String agreement, InputStream netIn, OutputStream netOut) throws IOException {
//        先取得文件下载路径
        String fileName = AgreementUtil.getFileName(agreement);
        //        将虚拟路径转换为服务器路径
        String filePath = fileName.replace("root",rootDir.toString());
        File targetFile = new File((filePath));
//        检查要下载的文件是否存在
        if(!targetFile.exists()){
//            如果不存在就，封装协议信息传递给前端
            String response = AgreementUtil.getAgreement("DOWNLOAD",fileName,"FAILED","目标文件不存在!");
            AgreementUtil.sendAgreement(netOut,response);
            return;
        }
        // 检查是否为文件
        if (!targetFile.isFile()) {
            String response = AgreementUtil.getAgreement("DOWNLOAD", fileName, "FAILED", "目标路径不是文件!");
            AgreementUtil.sendAgreement(netOut, response);
            return;
        }
        // 检查文件大小是否可用
        long fileSize = targetFile.length();
        if (fileSize <= 0) {
            String response = AgreementUtil.getAgreement("DOWNLOAD", fileName, "FAILED", "文件为空或无效!");
            AgreementUtil.sendAgreement(netOut, response);
            return;
        }
        // 发送READY协议，包含文件大小信息
        String fileSizeStr = String.valueOf(fileSize);
        String readyResponse = AgreementUtil.getAgreement("DOWNLOAD", fileName, "READY", fileSizeStr);
        AgreementUtil.sendAgreement(netOut, readyResponse);


        // 等待客户端的确认响应
        String clientResponse = AgreementUtil.receiveAgreement(netIn);
        String clientStatus = AgreementUtil.getStatus(clientResponse);

        if (!"READY".equals(clientStatus)) {
            // 客户端未准备好，中止传输
            String errorResponse = AgreementUtil.getAgreement("DOWNLOAD", fileName, "FAILED", "客户端未准备好接收");
            AgreementUtil.sendAgreement(netOut, errorResponse);
            return;
        }
        // 开始传输文件
        try (FileInputStream fileIn = new FileInputStream(targetFile)) {
            // 使用固定缓冲区提高传输效率
            byte[] buffer = new byte[8192]; // 8KB 缓冲区
            long bytesSent = 0;
            int readBytes;

            // 实时显示传输进度（可选）
            System.out.println("开始传输文件: " + fileName + " (" + fileSize + " bytes)");

            while ((readBytes = fileIn.read(buffer)) != -1) {
                netOut.write(buffer, 0, readBytes);
                bytesSent += readBytes;

                // 每传输1MB打印一次进度
                if (bytesSent % (1024 * 1024) == 0) {
                    System.out.printf("已传输: %.1f MB (%.1f%%)\n",
                            bytesSent / (1024.0 * 1024.0),
                            bytesSent * 100.0 / fileSize);
                }
            }

            // 确保所有数据都已刷新到网络
            netOut.flush();
            System.out.println("文件传输完成");

            // 发送最终成功响应
            String successResponse = AgreementUtil.getAgreement("DOWNLOAD", fileName, "OK", "文件传输完成");
            AgreementUtil.sendAgreement(netOut, successResponse);
        } catch (IOException e) {
            String errorResponse = AgreementUtil.getAgreement("DOWNLOAD", fileName, "FAILED", "下载失败: " + e.getMessage());
            AgreementUtil.sendAgreement(netOut, errorResponse);
            throw e;
        }
    }
}