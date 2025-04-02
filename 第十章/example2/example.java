package example2;

import java.io.*;


public class example {
    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try (FileOutputStream fos = new FileOutputStream("./InAndOut.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8")) {
            for (int i = 0; i < data.length; i++) {
                osw.write(data[i] + "\n"); // 写入每个整数并换行
            }
            osw.flush(); // 确保所有数据都被写入文件
            System.out.println("写入完成，开始读取...");

            try (FileInputStream fis = new FileInputStream("./InAndOut.txt");
                 InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                 BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    int value = Integer.parseInt(line.trim());
                    System.out.println("读取到的值: " + value);
                }
            }
        } catch (IOException e) {
            System.out.println("发生IO错误: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生错误: " + e.getMessage());
        }
    }
}
//RandomAccessFile不支持直接指定字符编码，因此无法直接使用UTF-8编码进行写入。
// RandomAccessFile主要用于读写二进制数据，而不是文本数据。
// 如果需要使用UTF-8编码写入文本数据，可以考虑使用FileOutputStream和OutputStreamWriter。