package example5;

public class example5 {
    public static void main(String[] args) {
        ComputerAverage c;
        double a = 12.7;
        double b = 56.5;
        c = new A();
        double result = c.average(a, b);
        System.out.println("通过A类实现的计算平均数"+result);
        c = new B();
        result = c.average(a, b);
        System.out.println("通过B类实现的计算算数平方根，也就是开方"+result);
    }
}
