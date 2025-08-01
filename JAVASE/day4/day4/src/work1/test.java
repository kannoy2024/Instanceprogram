package work1;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        // 创建一个ArrayList并添加一些测试数据
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // 测试查找存在的元素
        System.out.println(listTest(list, 30)); // 应该输出: 2

        // 测试查找不存在的元素
        System.out.println(listTest(list, 60)); // 应该输出: -1

        // 测试查找第一个元素
        System.out.println(listTest(list, 10)); // 应该输出: 0

        // 测试查找最后一个元素
        System.out.println(listTest(list, 50)); // 应该输出: 4
    }

    public static int listTest(ArrayList<Integer> list, Integer num) {
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (integer.equals(num)) {
                return i;
            }
        }
        return -1;
    }
}