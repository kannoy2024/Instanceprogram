package work6;

import java.util.HashMap;
import java.util.Map;

public class work8 {
    public static void main(String[] args) {
        String str = "dasdsafsasdasasasadasadafafdasf";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character charAt = str.charAt(i);

            if (map.containsKey(charAt)) {
                Integer integer = map.get(charAt);
                integer++;
                map.put(charAt, integer);
            } else {
                map.put(charAt, 1);
            }

        }
        // System.out.println(map);

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        });
    }
}
