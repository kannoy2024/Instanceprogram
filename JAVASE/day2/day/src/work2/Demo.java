package work2;

public class Demo {
public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    inner.show();
    //内部类的使用
}
}

class Outer {
 public int number = 10;
 class Inner{
    public int number = 20;
    public void show(){
        int number = 30;
        System.out.println(number);
        System.out.println(Outer.this.number);
        System.out.println(this.number);
    }
 }
}
