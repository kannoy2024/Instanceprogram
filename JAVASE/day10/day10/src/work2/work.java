package work2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class work {
    public static void main(String[] args) {
        // 使用 try-with-resources 自动管理所有流资源的关闭
        try (FileInputStream file = new FileInputStream(
                    "F:\\Directory_of_files_used_for_testing_code\\Files_saved_in_ANSI_format.txt");
             InputStreamReader inputStream = new InputStreamReader(file, "GBK");
             FileOutputStream fileOutputStream = new FileOutputStream(
                    "F:\\Directory_of_files_used_for_testing_code\\Files_saved_in_UTF-8_format.txt");
             OutputStreamWriter outputStream = new OutputStreamWriter(fileOutputStream, "UTF-8")) {
            
            // 转换流，用来读取特定的编码格式的文件
            int data = inputStream.read();

            System.out.println("拿到的输出流::" + (char) data);

            // 创建输出流，指定关联文件的编码表名字。
            outputStream.write(data);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}