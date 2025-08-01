package work4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//使用迭代器遍历
public class Test {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("hello");
        coll.add("world");
        coll.add("java企业级应用与开发");
        coll.add("Mysql从入门到精通");

        Iterator<String> iterable = coll.iterator();
        while (iterable.hasNext()) {
            String next = iterable.next();
            System.out.println(next);
        }
    } 
}
