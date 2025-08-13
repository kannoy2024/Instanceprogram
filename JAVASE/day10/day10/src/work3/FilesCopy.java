package work3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FilesCopy {
    public static void main(String[] args) {
        String secPath = "F:\\Directory_of_files_used_for_testing_code\\chun.txt";
        String desPath = "F:\\Directory_of_files_used_for_testing_code\\chun_copy.txt";
        long start = System.currentTimeMillis();
        copy(secPath, desPath);
        long end = System.currentTimeMillis();
        System.out.println("复制完成");
        System.out.println("文件复制花费的时间" + (end - start) + "毫秒");
    }

    public static void copy(String src, String dest) {
        // 这种复制形式是将一个文件的内容一个一个字节的读取，写入到另一个文件中
        try (FileInputStream file = new FileInputStream(src);
                FileOutputStream out = new FileOutputStream(dest);) {
            int data = -1;
            while ((data = file.read()) != -1) {
                out.write(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
