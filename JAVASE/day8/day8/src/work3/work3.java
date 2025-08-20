package work3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class work3 {
    // public static void main(String[] args) {
    //     List<Integer> list = new ArrayList<>();
    //     Collections.addAll(list, 243, 5, 65, 65, 6878, 687, 76, 7, 5, 34, 42, 3, 2);

    //     list = list.stream()
    //             .filter(num -> num % 2 == 0)
    //             .collect(Collectors.toList());

    //     System.out.println(list);//这种方法是将流对象转换成集合对象
    // }
     public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 243, 5, 65, 65, 6878, 687, 76, 7, 5, 34, 42, 3, 2);

        Integer[] arrayIntegers = list.stream()
                .filter(num -> num % 2 == 0)
                .toArray(value -> new Integer[value]);

        System.out.println(Arrays.toString(arrayIntegers));//这种方法将流对象转换成数组对象
    }
}
