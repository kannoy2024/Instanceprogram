import java.util.Scanner;
public class Scanner1 {
    public static void main(String[] args) {
        System.out.println("用空格或回车做分割，输入若干个数\n"+
        "最后输入数字0，回车结束输入");
        try (Scanner reader = new Scanner(System.in)) {
            double sum=0;
            //java的毛病，声明对象要记得及时关闭
            double x = reader.nextDouble();
            while(x!=0){
                sum+=x;
                x = reader.nextDouble();
            }//通过这种方式来获得一串数据
            System.out.println("总和为"+sum);
        }
    }
}
