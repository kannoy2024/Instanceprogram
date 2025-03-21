import java.util.*;
public class example2 {
    public static void main(String[] args) {
        String []a={"apple","banana","orange","pear"};
        String []b={"苹果","香蕉","橙子","梨"};
        System.out.println("使用SortString类的方法按字典序排列数组a:");
        SortString.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.println("      "+a[i]);
        }
        System.out.println("  ");
        System.out.println("使用类库中的arrays类,按字典排序数组b:");
        Arrays.sort(b);
        for(int i=0;i<b.length;i++){
            System.out.println("      "+b[i]);
        }
    }
}
