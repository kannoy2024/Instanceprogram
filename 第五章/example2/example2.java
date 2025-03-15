//面向抽象编程
//抽象类封装了子类必须实现的方法，必须要有的行为标准
//抽象类声明的对象可以成为其子类的对象的上转型对象。体现子类根据抽象类中的行为标准来实现自己的行为
abstract class GirlFriend{
    abstract void speak();
    abstract void cook();
}
class ChinaGirlFriend extends GirlFriend {
    void speak(){
        System.out.println("中国女朋友说：你好");
    }
    void cook(){
        System.out.println("中国女朋友做饭");
    }
}
class AmericanGirl extends GirlFriend {
    void speak(){
        System.out.println("美国女朋友说：Hello");
    }
    void cook(){
        System.out.println("美国女朋友做饭");
    }
}
class Boy{
    GirlFriend gf;
    void setGirlFriend(GirlFriend gf ) {
        this.gf = gf;
    }
    void show(){
        gf.speak();
        gf.cook();
    }
}
public class example2 {
    public static void main(String[] args) {
        GirlFriend girl1 = new ChinaGirlFriend();
        Boy boy1 = new Boy();
        boy1.setGirlFriend(girl1);
        boy1.show();
        girl1 = new AmericanGirl();
        boy1.setGirlFriend(girl1);
        boy1.show();
    }
}
