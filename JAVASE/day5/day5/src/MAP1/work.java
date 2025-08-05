package MAP1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class work {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("qinyuan", "S  ");
        map.put("qinuan", "S  ");
        map.put("qis", "S  ");
        map.put("qin", "S  ");
        map.put("qdddn", "S  ");


        if(map.containsKey("qis")){
            map.remove("qis");
        }
// 通过key获取value，的方法来遍历
        Set<String> keys = map.keySet();
        for (String keys2 : keys) {
            String value = map.get(keys2);
            System.out.println(keys2 + ":" + value);
        }

        System.out.println("----------------------------------------");
// 通过entrySet来遍历,取得全部的键值对再进行遍历
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        for(Map.Entry<String, String> entry : entrySet){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        System.out.println(map);
    }
}
