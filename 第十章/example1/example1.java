package example1;

import java.io.*;
import java.util.*;

public class example1 {
    public static void main(String[] args) {
        // 创建一个File对象，指向当前目录下的english.txt文件
        File FRead = new File("./english.txt");
        // 创建一个File对象，指向当前目录下的english_copy.txt文件
        File FWrite = new File("./english_copy.txt");
        try {
            // 创建一个FileWriter对象，用于向FWrite文件写入数据
            Writer out = new FileWriter(FWrite);
            // 创建一个BufferedWriter对象，用于高效地写入文本数据
            BufferedWriter BufferedWriter = new BufferedWriter(out);
            // 创建一个FileReader对象，用于从FRead文件读取数据
            Reader in = new FileReader(FRead);
            // 创建一个BufferedReader对象，用于高效地读取文本数据
            BufferedReader BufferedReader = new BufferedReader(in);
            String str = null;
            // 逐行读取FRead文件的内容
            while ((str = BufferedReader.readLine()) != null) {
                // 使用StringTokenizer将读取的字符串按空格分割成单词
                StringTokenizer st = new StringTokenizer(str);
                // 获取单词的数量
                int count = st.countTokens();
                // 将单词数量附加到原始字符串后面
                str = str + " 句子中的单词数量：  " + count;
                // 将处理后的字符串写入FWrite文件
                BufferedWriter.write(str);
                // 写入换行符
                BufferedWriter.newLine();
            }
            // 关闭BufferedWriter，释放资源
            BufferedWriter.close();
            // 关闭Writer，释放资源
            out.close();
            // 重新打开FWrite文件，准备读取写入的内容
            in = new FileReader(FWrite);
            // 创建一个新的BufferedReader对象，用于读取FWrite文件的内容
            BufferedReader = new BufferedReader(in);
            String s = null;
            // 打印FWrite文件的名称
            System.out.println("文件内容如下：" + FWrite.getName());
            // 逐行读取FWrite文件的内容并打印到控制台
            while ((s = BufferedReader.readLine()) != null) {
                System.out.println(s);
            }
            // 关闭BufferedReader，释放资源
            BufferedReader.close();
            // 关闭Reader，释放资源
            in.close();
        } catch (FileNotFoundException e) {
            // 捕获文件未找到异常，并打印错误信息
            System.out.println("文件未找到: " + e.getMessage());
        } catch (IOException e) {
            // 捕获IO异常，并打印错误信息
            System.out.println("发生IO错误: " + e.getMessage());
        } catch (Exception e) {
            // 捕获其他异常，并打印错误信息
            System.out.println("发生错误: " + e.getMessage());
        }
    }
}