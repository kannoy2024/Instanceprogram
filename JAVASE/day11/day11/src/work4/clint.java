package work4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class clint {
    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 9999);
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();) {
            System.out.println("开始发送数据");
            os.write("你好".getBytes());

            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            String content = new String(bytes, 0, len);
            System.out.println(content);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
