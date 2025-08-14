package work4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        try (ServerSocket serverSocket = new ServerSocket(9999);
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();) {

            System.out.println("客户端连接成功");
            System.out.println("客户端信息：" + socket.getInetAddress().getHostAddress());

            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            String content = new String(bytes, 0, len);

            System.out.println(content);

            OutputStream os = socket.getOutputStream();
            os.write("欢迎您！".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
