package work3;

import java.util.Scanner;

public class Stringliend {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生信息：（姓名年龄身高）");
        String data = sc.nextLine();

        String[] arr = data.split("-");
        student.setName(arr[0]);
        student.setAge(Integer.parseInt(arr[1]));
        student.setHeight(Double.parseDouble(arr[2]));

        System.out.println("学生信息：" + student.getName() + " " + student.getAge() + " " + student.getHeight());
        System.out.println("学生信息：" + student);
    }
}
