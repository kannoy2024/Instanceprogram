package work6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class work6 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
//  使用Collections.addAll()方法，批量添加元素
        Collections.addAll(list, "JAVA","C++","Python");
    
        System.out.println(list);

    }
}
