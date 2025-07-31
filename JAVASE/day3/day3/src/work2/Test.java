package work2;

import java.util.Scanner;
//包装类的使用，就是为了String可以转换成其他的基本数据类型
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生性别：");
        String sex = sc.nextLine();
        System.out.println("请输入学生学号：");
        String id = sc.nextLine();
        System.out.println("请输入学生年级：");
        String grade = sc.nextLine();

        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setSex(sex);
        student.setId(id);
        student.setGrade(grade);

        System.out.println("学生信息：" + student.getName() + " " + student.getAge() + " " + student.getSex() + " " + student.getId() + " " + student.getGrade());
        System.out.println("学生信息：" + student);
    }
}
