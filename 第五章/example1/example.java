class 类人猿{
    void 说话(String s){
        System.out.println(s);
    }
}
class 人 extends 类人猿{
    void 说话(String s){
        System.out.println("人类说："+s);
    }
}
public class example {
public static void main(String[] args) {
    类人猿 a = new 类人猿();
    人 b = new 人();
    a.说话("Hello");
    b.说话("Hello");
}
}
