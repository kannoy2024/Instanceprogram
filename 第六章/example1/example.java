public class example {
    public static void main(String[] args) {
        AAA a = new AAA();
        System.out.println("接口中的常量"+AAA.max);
        System.out.println("调用on方法(重写的)：");
        a.on();
        System.out.println("调用sum方法(重写的)"+a.sum(16, 98));
        System.out.println("调用接口提供的default方法"+a.max(12, 056));
        Com.f();
    }
}
