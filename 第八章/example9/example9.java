package example9;

import java.util.Scanner;
// import java.util.regex.Pattern;
// import java.util.regex.Matcher;

public class example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 正则表达式示例
        String regexAlphanumericUnderscore = "[a-zA-Z0-9_]+";
        String regexDigit = "-?[1-9]\\d*";
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String regexPhoneNumber = "^\\+?[1-9]\\d{1,14}$"; // 国际电话号码格式

        System.out.println("请输入一个字符串：");
        String input = scanner.nextLine();

        // 验证字母数字下划线
        if (input.matches(regexAlphanumericUnderscore)) {
            System.out.println(input + " 是字母数字下划线");
        } else {
            System.out.println(input + " 不是字母数字下划线");
        }

        // 验证数字
        if (input.matches(regexDigit)) {
            System.out.println(input + " 是一个数字");
        } else {
            System.out.println(input + " 不是一个数字");
        }

        // 验证电子邮件地址
        if (input.matches(regexEmail)) {
            System.out.println(input + " 是一个有效的电子邮件地址");
        } else {
            System.out.println(input + " 不是一个有效的电子邮件地址");
        }

        // 验证电话号码
        if (input.matches(regexPhoneNumber)) {
            System.out.println(input + " 是一个有效的电话号码");
        } else {
            System.out.println(input + " 不是一个有效的电话号码");
        }

        scanner.close();
    }
}