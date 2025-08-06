package work6;

import java.util.HashMap;

public class work7 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("张三", "5000");
        map.put("王五", "6000");
        map.put("赵六", "7000");
        // 当键值对已经存在时，会覆盖
        map.put("张三", map.get("张三") + 1000);

        System.out.println(map);
    }
}
