package work5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class clint {
    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 9999);
                OutputStream os = socket.getOutputStream();
                FileInputStream fis = new FileInputStream(new File("F:\\MaterialLibrary\\apple.jpg"));
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);) {

            System.out.println("开始发送数据");
            os.write("你好".getBytes());

            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            socket.shutdownOutput();
            System.out.println("发送完毕");

            String line = br.readLine();
            System.out.println("客户端接收到的数据"+line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
