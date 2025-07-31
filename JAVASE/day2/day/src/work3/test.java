package work3;

public class test {
    public static void main(String[] args) {
        student s = new student("张三", 18, "男");
        System.out.println(s.getName() + " " + s.getAge() + " " + s.getSex());
        System.out.println(s);

        student s1 = new student("张三", 18, "男");
         System.out.println(s1.equals(s));


    }
}
