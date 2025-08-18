package com.ithiema.service;

import com.ithiema.exception.BusinessException;
import com.ithiema.util.AgreementUtil;
import com.ithiema.util.IOUtil;

import java.io.*;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
    ctrl + shift + "-" : 收缩所有的方法快捷键
    ctrl + shift + "+" : 展开所有的方法快捷键
    ctrl + alt + 左键 : 回退
    ctrl + alt + 右键 : 前进
 */
public class FileUpDownServiceImp implements FileUpDownService {
    /**
     * 用来保存当前浏览的目录
     * 解释 : 其实就是服务器存储数据的文件夹路径
     * 服务器src根目录下的yunpan.properties中的 rootDir
     */
    public File current = new File("root");
    private ResourceBundle bundle;
    private String downloadPath;// 下载的路径

    @Override
    public void start() {
        try {
            // 初始化下载路径，读取配置文件中的数据
            // ResourceBundle读取的是src下的properties文件
            bundle = ResourceBundle.getBundle("yunpan");

            // 根据文件中的键找到对应的值 , 获取对应的值 ---> 就是下载的路径
            // "D:\\download"
            downloadPath = bundle.getString("DownloadPath");

            // 把下载的路径的字符串 , 封装成一个File对象
            File downloadDir = new File(downloadPath);

            // 判断此路径是否是一个文件夹路径
            // 什么时候会抛出异常 ? 此路径是一个文件 , 文件不存在还创建失败了!
            if (downloadDir.isFile()) {
                throw new BusinessException("文件不能当做下载目录，请更改下载路径配置！");
            } else if (!downloadDir.exists() && !downloadDir.mkdirs()) {
                throw new BusinessException("下载目录初始化失败，请检查下载路径配置是否正确！");
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("*******欢迎进入黑马网盘*******");

            while (true) {
                System.out.println("***************************************************************************");
                System.out.println("1)浏览当前目录 \t2)浏览子目录 \t3)返回上一级目录 \t4)下载文件 \t5)上传文件");
                System.out.println("***************************************************************************");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        scanDirection(current);
                        break;
                    case "2":
                        System.out.println("请输入要浏览的子目录：");
                        String dir = sc.nextLine();
                        try {
                            //扫描
                            scanDirection(new File(current, dir));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        if (current.getName().equals("root")) {
                            System.out.println("没有上一级了");
                        } else {
                            scanDirection(current.getParentFile());
                        }
                        break;
                    case "4":
                        //下载
                        System.out.println("请输入要下载的文件名（含后缀）:");
                        String fileName = sc.nextLine();
                        downloadFile(new File(current, fileName));
                        break;
                    case "5":
                        while (true) {
                            System.out.println("请输入在计算机中要上传的文件路径");
                            String uploadFilePath = sc.nextLine();
                            File upFile = new File(uploadFilePath);
                            if (!upFile.exists()) {
                                System.out.println("文件不存在，请重新输入！");
                            } else if (upFile.isDirectory()) {
                                System.out.println("抱歉，不支持目录上传！");
                            } else if (upFile.isFile()) {
                                uploadFile(upFile);
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("功能尚在开发中....");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 文件浏览
    @Override
    public void scanDirection(File path) {
        //连接服务端
        try (Socket socket = new Socket("127.0.0.1", 8888);
             // 用来客户端读取服务端的数据
             InputStream netIn = socket.getInputStream();
             // 用来客户端给服务端发送数据
             OutputStream netOut = socket.getOutputStream()
        ) {
            /*
                获取了协议
                解析 : 拿到协议对象 , 协议对象中封装的是要做浏览数据 , 操作文件的路径
                scanDirProtocol对象 : scan , root
            */
            String scan = AgreementUtil.getAgreement("SCAN", path.getName(), null, null);

            // 给服务端发送协议
            AgreementUtil.sendAgreement(netOut, scan);

            System.out.println("===============等待服务器给回应消息================");

            //接收消息
            BufferedReader br = new BufferedReader(new InputStreamReader(netIn));

            String content;
            //System.out.println("开始接收数据：");
            String firstLine = br.readLine();//协议 , 阻塞

            // 把服务端发送过来的一行协议字符串 , 封装成协议对象
            String type = AgreementUtil.getStatus(firstLine);
            // 获取协议对象中的状态
            if (type.equals("OK")) {
                // 成功
                // 服务端发过来的真正存储数据的file路径, 覆盖给current变量
                current = new File(AgreementUtil.getFileName(firstLine));
                System.out.println("当前目录：" + current);
                while ((content = br.readLine()) != null) {
                    System.out.println(content);
                }
            } else {
                // 失败
                System.out.println("浏览失败:" + AgreementUtil.getMessage(firstLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 文件下载
    public void downloadFile(File file) {
        // 创建服务器连接
        try (Socket socket = new Socket("127.0.0.1", 8888);
             OutputStream netOut = socket.getOutputStream();
             InputStream netIn = socket.getInputStream()) {

            // 构建下载协议（使用相对路径）
            String relativePath = getRelativePath(file);
            String downloadAgreement = AgreementUtil.getAgreement(
                    "DOWNLOAD", relativePath, null, null);

            // 发送下载协议
            AgreementUtil.sendAgreement(netOut, downloadAgreement);

            // 读取服务器响应协议
            String agreementLine = AgreementUtil.receiveAgreement(netIn);
            String status = AgreementUtil.getStatus(agreementLine);

            if ("OK".equals(status)) {
                // 准备保存下载文件
                File downloadFile = new File(downloadPath, file.getName());
                try (FileOutputStream fos = new FileOutputStream(downloadFile)) {
                    // 复制网络数据流到文件
                    IOUtil.copy(netIn, fos);
                    System.out.println("文件下载成功，保存位置: " + downloadFile.getAbsolutePath());
                }
            } else {
                System.out.println("下载失败: " + AgreementUtil.getMessage(agreementLine));
            }
        } catch (IOException e) {
            System.out.println("下载过程发生异常: " + e.getMessage());
        }
    }

    // 文件上传
    @Override
    public void uploadFile(File upFile) {
        try (Socket socket = new Socket("127.0.0.1", 8888);
             OutputStream netOut = socket.getOutputStream();
             InputStream netIn = socket.getInputStream();
             FileInputStream fis = new FileInputStream(upFile)) {

            // 构建上传协议
            String serverPath = getRelativePath(current);
            String uploadAgreement = AgreementUtil.getAgreement(
                    "UPLOAD", serverPath + "/" + upFile.getName(), null, null);

            // 发送上传协议
            AgreementUtil.sendAgreement(netOut, uploadAgreement);

            // 读取服务器响应
            String agreementLine = AgreementUtil.receiveAgreement(netIn);
            String status = AgreementUtil.getStatus(agreementLine);

            if ("OK".equals(status)) {
                // 上传文件内容
                IOUtil.copy(fis, netOut);
                // 确保数据发送完毕
                netOut.flush();

                // 等待服务器完成处理
                agreementLine = AgreementUtil.receiveAgreement(netIn);
                status = AgreementUtil.getStatus(agreementLine);

                if ("OK".equals(status)) {
                    System.out.println("文件上传成功！");
                } else {
                    System.out.println("上传失败: " + AgreementUtil.getMessage(agreementLine));
                }
            } else {
                System.out.println("服务器拒绝上传: " + AgreementUtil.getMessage(agreementLine));
            }
        } catch (IOException e) {
            System.out.println("上传过程中发生错误: " + e.getMessage());
        }
    }


    // 获取文件相对路径（相对于root目录）
    private String getRelativePath(File file) {
        File root = new File("root");
        String absolutePath = file.getAbsolutePath();
        String rootPath = root.getAbsolutePath();

        // 计算相对路径
        if (absolutePath.startsWith(rootPath)) {
            String relativePath = absolutePath.substring(rootPath.length());
            return relativePath.replace(File.separator, "/");
        }
        return absolutePath.replace(File.separator, "/");
    }
}
