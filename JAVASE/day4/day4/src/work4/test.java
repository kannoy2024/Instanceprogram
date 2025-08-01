package work4;

import java.util.LinkedHashSet;

public class test {
    public static void main(String[] args) {
        LinkedHashSet<Integer>  set = new LinkedHashSet<>();
        set.add(20);
        set.add(39);
        set.add(10);  
        set.add(20);


        System.out.println(set.size());
        System.out.println("**************************");
        for (Integer set2 : set) {
            System.out.println(set2);
        }
    }
}
