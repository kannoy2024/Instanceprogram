package com.itheima.service;

import com.itheima.exception.BusinessException;
import com.itheima.util.AgreementUtil;
import com.itheima.util.IOUtil;

import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;

/*
    协议定义:   协议+数据
    第一行是协议，第二行开始就是数据
 */
public class FileUpDownServiceImp implements Runnable, FileUpDownService {

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
            // 读协议
            final String agreement = AgreementUtil.receiveAgreement(netIn);
            // System.out.println("接收客户端数据：" + agreement);

            // 解析字符串
            String type = AgreementUtil.getType(agreement);
            // System.out.println("解析字符串的数据类型:" + type);
            switch (type) {
                case "SCAN"://客户端要浏览
                    scanDirectory(agreement, netIn, netOut);
                    break;
                case "DOWNLOAD"://客户端要下载
                    downloadFile(agreement, netIn, netOut);
                    break;
                case "UPLOAD"://客户端要上传
                    uploadFile(agreement, netIn, netOut);
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

    // 文件上传功能
    @Override
    public void uploadFile(String agreement, InputStream netIn, OutputStream netOut) throws IOException {
//        先要取得文件上传路径
        String fileName = AgreementUtil.getFileName(agreement);
//        将虚拟路径转换为服务器路径
        String filePath = fileName.replace("root",rootDir.toString());
        File targetFile = new File((filePath));

//        检查文件是否存在
        if(targetFile.exists()){
//            如果已经存在就，封装协议信息传递给前端
            String response = AgreementUtil.getAgreement("UPLOAD",fileName,"FAILED","文件已存在");
            AgreementUtil.sendAgreement(netOut,response);
            return;
        }
//        检查父文件目录是否存在，不存在则创建
        File parentDir  = targetFile.getParentFile();
        if(!parentDir.exists() && !parentDir.mkdirs()){
            String response = AgreementUtil.getAgreement("UPLOAD",fileName,"FAILED","无法创建目录");
            AgreementUtil.sendAgreement(netOut,response);
            return;
        }
//如果前面的全部内容都通过了，那么就可以开始接受上传文件了
        String readyResponse = AgreementUtil.getAgreement("UPLOAD",fileName,"READY","");
        AgreementUtil.sendAgreement(netOut,readyResponse);


        // 接收文件数据
        try (FileOutputStream fileOut = new FileOutputStream(targetFile)) {
            IOUtil.copy(netIn, fileOut);

            // 上传完成后发送成功响应
            String successResponse = AgreementUtil.getAgreement("UPLOAD", fileName, "OK", "文件上传成功");
            AgreementUtil.sendAgreement(netOut, successResponse);
        } catch (IOException e) {
            // 删除可能已部分写入的文件
            if (targetFile.exists()) {
                targetFile.delete();
            }

            String errorResponse = AgreementUtil.getAgreement("UPLOAD", fileName, "FAILED", "文件上传失败: " + e.getMessage());
            AgreementUtil.sendAgreement(netOut, errorResponse);
            throw e;
        }
    }

    // 文件下载功能
    @Override
    public void downloadFile(String agreement, InputStream netIn, OutputStream netOut) throws IOException {
    }
}