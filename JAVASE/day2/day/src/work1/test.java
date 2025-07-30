package work1;

public class test {
    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        Programmer programmer = new Programmer("张三", 5000);
        Manager manager = new Manager("李四", 10000);
        Company company = new Company(1000000000);
        company.pay(programmer);
        company.pay(manager);
        long timeMillis2 = System.currentTimeMillis();
        System.out.println(timeMillis2);
        System.out.println("方法的执行时间"+(timeMillis2-timeMillis)+"毫秒");
    }

}
