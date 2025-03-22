package example4;
import java.util.Date;
public class example4 {
    public static void main(String[] args) {
        Date d=new Date();
        System.out.println(d.toString());
        int address =System.identityHashCode(d);
        System.out.printf("Date的对象的引用%x:\n",address);
        TV tv=new TV();
        tv.setPrice(1000);
        System.out.println("tv的价格是");
          System.out.println(tv.toString());
         address = System.identityHashCode(tv);
         System.out.printf("TV的对象的引用%x:",address);
    }
}
