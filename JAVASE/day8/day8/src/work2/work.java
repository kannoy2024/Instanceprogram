package work2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class work {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 113, 23, 45, 67, 89);

        Collections.sort(list,(Integer o1, Integer o2)->o1.compareTo(o2));
        System.out.println(list);

    }
}
// //传统的匿名类，来实现升序排序
//         Collections.sort(list,new Comparator<Integer>() {
//             @Override
//             public int compare(Integer o1, Integer o2) {
//                 return o1.compareTo(o2);
//             }
//         });


// //lambda表达式，来实现升序排序
