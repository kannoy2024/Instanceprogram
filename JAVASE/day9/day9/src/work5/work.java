package work5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class work {
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream("f:/MaterialLibrary/hello.txt");

            int ch = (char) in.read();

            System.out.println(ch);
            // 当读取不到数据会返回-1
            // 需要注意，无论是否发生异常都要及时释放输入流

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
