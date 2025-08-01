package work3;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("张三");
        set.add("关羽");
        set.add("张飞");
        set.add("赵云");
        set.add("小王");

        System.out.println(set.size());

        System.out.println("******************************************");

        for (String set2 : set) {
            System.out.println(set2);
        }
        System.out.println("******************************************");
    }
}
