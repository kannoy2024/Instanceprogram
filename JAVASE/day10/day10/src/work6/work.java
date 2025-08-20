package work6;

import java.io.FileWriter;
import java.io.IOException;

public class work {
    public static void main(String[] args) throws IOException {
        // 使用字节流的形式读取文件
        FileWriter fileWriter = new FileWriter("F:\\Directory_of_files_used_for_testing_code\\chun.txt", true);
        fileWriter.write("hello world");
        fileWriter.close();
    }
}
