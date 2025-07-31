package work1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class work1 {
    public static void main(String[] args) {
        double[] arr = { 1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9, 9.0 };


        BigDecimal sum = new BigDecimal(0);
        //大浮点数存在精度丢失，传值最好用字符串
        for (double arr2 : arr) { 
            sum = sum.add(new BigDecimal(arr2));
        }
        
        System.out.println("总和："+ sum.doubleValue());

        BigDecimal len = new BigDecimal(arr.length);

        BigDecimal avg = sum.divide(len,2,RoundingMode.HALF_UP);

        System.out.println("平均数："+ avg.doubleValue());
    }
}
