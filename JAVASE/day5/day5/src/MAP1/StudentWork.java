package MAP1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentWork {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("张三", "北京");
        map.put("王五", "上海");
        map.put("赵六", "广州");
        map.put("赵六", "合肥");
        map.put("小明", "深圳");
// 在map集合中key存储的是自定义对象时，要保证对象存储数据的唯一性，
// 需要重写自定义对象中的唯一标识符hashCode()和equals()方法
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "" + map.get(key));
        }


        
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for(Map.Entry<String, String> entry : entrySet){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
