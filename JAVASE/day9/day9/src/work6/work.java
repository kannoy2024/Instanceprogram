package work6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class work {
    public static void main(String[] args) throws IOException {
        // try-with-resources,通过将流对象的定义放置在try()小括号中，可以实现自动监控，自动释放。比较推荐
        try(InputStream in=new FileInputStream("f:/MaterialLibrary/hello.txt");) {
            int ch = (char) in.read();

            System.out.println(ch);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
