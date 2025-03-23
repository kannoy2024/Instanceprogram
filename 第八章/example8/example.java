package example8;

import java.util.Scanner;

//学习正则表达式
public class example {
    public static void main(String[] args) {
    String regex = "[a-zA-Z|0-9|_]+";
    String regexDigit = "-?[1-9]\\d*";
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (input.matches(regex)) {
        System.out.println(input+"输入是字母数字下划线");
        if(input.matches(regexDigit)){
            System.out.println("数字部分是"+input);
        }
    } else {
        System.out.println("匹配失败");
    }
    scanner.close();
    }
}
