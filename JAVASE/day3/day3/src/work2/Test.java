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
        System.out.println("请输入学生身高：");
        String height = sc.nextLine();
        System.out.println("请输入学生是否结婚：");
        String isMarried = sc.nextLine();
        System.out.println("请输入学生性别：");
        String sex = sc.nextLine();
        

        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setHeight(Double.parseDouble(height));
        student.setMarried(Boolean.parseBoolean(isMarried));
        student.setSex(sex.charAt(0));
    
        System.out.println("学生姓名"+student);
    }
}
