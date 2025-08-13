package ResourceBundle;

public class ResourceBundleTest {
    // 在JAVA中有现成的工具类：ResourceBundle专门用来读取资源文件
    public static void main(String[] args) {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com.atguigu.properties.message");
        System.out.println(bundle.getString("name"));
        System.out.println(bundle.getString("age"));
        System.out.println(bundle.getString("address"));

    }
}
