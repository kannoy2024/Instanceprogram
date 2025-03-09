import java.util.*;
public class example3_9 {
    public static void main(String[] args) {
        System.out.println("请输入一些数字，以回车分割，end结束");
        try(Scanner reader = new Scanner(System.in)){
        double sum = 0;
        int m = 0;
        while(reader.hasNextDouble()){
            double x = reader.nextDouble();
            m =m + 1;
            sum = sum +x;
        }
        System.out.printf("%d个数的和为%f\n",m,sum);
        if(m > 0){
            System.out.printf("%d个数的平均值为%f\n",m,sum/m);
        }else{
            System.out.println("没有输入任何数字");
        }
        
    }
}
}
