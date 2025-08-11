package StreamDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Collections.addAll(list, "张三", "李四", "张大宝", "王小宝", "张王山");
        // Stream流，下一步的操作是基于前一个操作的结果进行操作。
        // 获取Stream流
        // 中间方法（处理）
        // 终结方法（获取结果）
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(System.out::println);
    }
}
