

public class Client {
    public static void main(String[] args) {
        ClassBell bell = new ClassBell();
        // 注册观察者
        Observer student1 = new Student("张三");
        Observer student2 = new Student("李四");
        Observer teacher = new Teacher("王老师");

        bell.attach(student1);
        bell.attach(student2);
        bell.attach(teacher);

         // 模拟上课铃响
        System.out.println("***准备上课***");
        bell.setBellState("上课铃响");

        // 模拟下课铃响
        System.out.println("\n***准备下课***");
        bell.setBellState("下课铃响");
    }
}
