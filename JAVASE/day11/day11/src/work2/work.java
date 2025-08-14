package work2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class work {
    // 学习打印流，主要是用来方便自动换行和打印日志
    public static void main(String[] args) throws IOException {
        // 如果文件不存在就会自动创建
        PrintStream ps = new PrintStream("F:\\Directory_of_files_used_for_testing_code\\dayin.txt");
        ps.println("hello world");
        ps.println("null");
        ps.println(123);
        ps.println(true);
        ps.println(12.34);
        ps.println('a');
        // 打印流能够打印各种各样的数据

        // 可以改变打印流的输出位置，使用System。setout
        System.setOut(ps);
    }
}
