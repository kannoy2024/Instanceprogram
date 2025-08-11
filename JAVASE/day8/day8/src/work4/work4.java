package work4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class work4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Collections.addAll(list,"张三,12","lishi,13","wangwu,14","showe,32","fdsjalfe,23");

//取出流对象，存入map
       Map<String,String> map = list.stream()
        .filter(str -> Integer.parseInt(str.split(",")[1])>=20)
        .collect((Collectors.toMap(s->s.split(",")[0], s ->s.split(",")[1])));

        System.out.println(map);
    }
}
