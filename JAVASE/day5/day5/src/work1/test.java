package work1;

import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        // TreeSet<Integer> ts = new TreeSet<>();

        // ts.add(20);
        // ts.add(39);
        // ts.add(10);
        // ts.add(20);
        // System.out.println(ts);
        // TreeSet具有对所储存元素进行排序的功能，元素唯一， 需要定义排序规则
       
        TreeSet<Student> ts = new TreeSet<>();
        ts.add(new Student("张三", 22));
        ts.add(new Student("张三", 12));
        ts.add(new Student("张三", 20));
        ts.add(new Student("王五", 23));
        ts.add(new Student("赵六", 18));
        ts.add(new Student("赵六", 18));

        for (Student ts2 : ts) {
            System.out.println(ts2);
        }
    }
}
