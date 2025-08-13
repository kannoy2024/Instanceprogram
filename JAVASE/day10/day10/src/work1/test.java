package work1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(
                    "F:\\Directory_of_files_used_for_testing_code\\Files_saved_in_ANSI_format.txt");
            InputStreamReader inputStream = new InputStreamReader(file, "GBK");
            // 字符流缓冲流。并把转换流作为参数传递。
            BufferedReader bufferedReader = new BufferedReader(inputStream);

            String line = bufferedReader.readLine();
            System.out.println("拿到的输出流______:" + line);

            BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(
                    "F:\\Directory_of_files_used_for_testing_code\\Files_saved_in_UTF-8_format.txt"));

            bufferedWriter.write(line);
            file.close();
            inputStream.close();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
