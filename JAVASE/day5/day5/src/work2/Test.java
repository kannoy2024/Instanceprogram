package work2;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int i = o1.length() - o2.length();
        if(i == 0){
            return o1.compareTo(o2);
        }
        return i;
    }
}

public class Test {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new MyComparator());
        // 重新排序内容，希望可以按照长度排序
        // String 类已经实现了Comparable接口，所以可以直接使用,但是是根据默认的字典排序。
        // 于是就会使用比较器来实现自定义排序。
        ts.add("hello world");
        ts.add("world");
        ts.add("java");
        ts.add("MySQl");
        System.out.println(ts);
    }
}
