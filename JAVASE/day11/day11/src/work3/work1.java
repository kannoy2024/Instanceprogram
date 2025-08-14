package work3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class work1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("等待客户端连接...");
        Socket socket = ss.accept();
        System.out.println("客户端连接成功");
        System.out.println("客户端信息：" + socket.getInetAddress().getHostAddress());
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);

        String content = new String(bytes, 0, len);
        System.out.println(content);
        socket.close();
        ss.close();
    }
}
