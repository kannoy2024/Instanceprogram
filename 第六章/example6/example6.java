package example6;

public class example6 {
    public static void main(String[] args) {
        KindHello  a = new KindHello();
        Chinese c = new Chinese();
        a.lookHello(c);
        a.lookHello(new English());
        a.lookHello(()->{
            System.out.println("一般来讲都不会用这个方法的");
        });
    }
}
