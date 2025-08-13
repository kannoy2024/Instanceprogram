package work3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesCopy_copy {
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
        // 定义一个数组，一次读取多个数据，来复制，提高效率
        try (FileInputStream file = new FileInputStream(src);
                FileOutputStream out = new FileOutputStream(dest);) {
            byte[] data = new byte[1024];
            int len = -1;
            while ((len = file.read(data)) != -1) {
                out.write(data, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
