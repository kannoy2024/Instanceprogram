
package interfaceAndExtend;

public class Test {
    public static void main(String[] args) {
        javaTeacher e1 = new javaTeacher("张三", 18, "男");
        uiTeacher e2 = new uiTeacher("李四", 19, "女");
        e1.work();
        e2.work();
        e2.draw();

    }
}
