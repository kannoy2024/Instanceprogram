package work4;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class work4 {
    public static void main(String[] args) throws Exception {
        //流对象是JAVA的重要对象，很多对象，声音，视频，文件，都可以通过流对象实现
        OutputStream out = new FileOutputStream("f:/MaterialLibrary/hello.txt",true);
        out.write("1666666".getBytes());
        out.write("\r\n".getBytes());//向文件中写入换行符号
        byte[] bytes = "\r\n hello world".getBytes();
        out.write(bytes,0,9);//将字节中的部分数据写入流中
        out.close();
    }
}
