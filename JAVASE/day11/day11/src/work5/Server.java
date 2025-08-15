package work5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) {
        System.out.println("等待客户端连接...");
        // String fileName = System.currentTimeMillis() + "";// 文件名
        String fileName = UUID.randomUUID().toString().replace("-", "");// 使用随机数生成文件名，开发中用的更多

        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            while (true) { // 服务端应该持续监听连接
                try (Socket socket = serverSocket.accept();
                        FileOutputStream fos = new FileOutputStream(
                                "F:/Directory_of_files_used_for_testing_code/" + fileName + ".jpg");
                        InputStream is = socket.getInputStream();
                        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
                        BufferedWriter bw = new BufferedWriter(os)) {

                    System.out.println("客户端信息：" + socket.getInetAddress().getHostAddress());

                    byte[] bytes = new byte[1024];
                    int len = -1;
                    while ((len = is.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    System.out.println("接收完毕");

                    // 发送成功响应
                    bw.write("文件上传成功");
                    bw.newLine();
                    bw.flush(); // 确保数据发送
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}