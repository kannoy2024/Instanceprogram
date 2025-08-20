package work4;

import java.util.Properties;

public class work {
    // Properties
    // 有时开发中需要读取的文件就是类似键值对的形式，就会使用Properties类
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name", "张三");
        properties.setProperty("age", "18");

        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));

        properties.stringPropertyNames().forEach(key -> {
            System.out.println(key + ":" + properties.getProperty(key));
        });
    }
}
