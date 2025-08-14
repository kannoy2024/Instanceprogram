package work5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        try (ServerSocket serverSocket = new ServerSocket(9999);
                Socket socket = serverSocket.accept();
                FileOutputStream fos = new FileOutputStream("F:\\Directory_of_files_used_for_testing_code\\banana.jpg");
                InputStream is = socket.getInputStream();
                OutputStreamWriter os = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(os)) {

            System.out.println("客户端连接成功");
            System.out.println("客户端信息：" + socket.getInetAddress().getHostAddress());

            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("接收完毕");
            bw.write("文件上传成功");
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
