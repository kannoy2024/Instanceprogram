package work3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        InnerTest("f:/MaterialLibrary");
    }

    public static void InnerTest(String string) {
        // 基于给定的路径
        File file = new File(string);
        if(!file.exists()){
            throw new RuntimeException("文件不存在");
        }
        Map<String , Integer> map = new HashMap<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()){
                System.out.println(file1.getName());

                String name = file1.getName();

                int index = name.lastIndexOf(".");
                String lastName = name.substring(index + 1);
                // System.out.println(lastName);
                if(map.containsKey(lastName)){
                    Integer value = map.get(lastName);
                    value++;
                    map.put(lastName, value);
                }else{
                    map.put(lastName, 1);

                }
            }else{
                InnerTest(file1.getAbsolutePath());
         
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
