package work1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class work1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, 243, 5, 65, 65, 6878, 687, 76, 7, 5, 34, 42, 3, 2);

        Optional<Integer> max = list.stream().max((Integer n1, Integer n2) -> n1.compareTo(n2));
        System.out.println(max);

        Optional<Integer> min = list.stream().min((Integer n1, Integer n2) -> n1.compareTo(n2));
        System.out.println(min);

        long count = list.stream().filter(num -> num % 2 == 0).count();

        System.out.println(count);
    }
}
