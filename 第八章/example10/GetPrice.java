package example10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetPrice {
    public static double givePriceSum(String cost){
        try(Scanner scanner = new Scanner(cost)){
        scanner.useDelimiter("[^0123456789.]+");// 设置分隔符为非数字字符
        double sum = 0;
        while (scanner.hasNext()){
            try {
                double price = scanner.nextDouble();// 尝试读取下一个数字
                sum += price; // 累加到总和
            } catch (InputMismatchException e) {// 跳过非数字部分
                String word = scanner.next();
            }
        }
        return sum;
    }
}
}

