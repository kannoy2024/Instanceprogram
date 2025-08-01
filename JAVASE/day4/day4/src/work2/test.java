package work2;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 18, "男");
        Student student2 = new Student("李四", 12, "女");
        Student student3 = new Student("王五", 23, "男");

        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        int MaxStudentIndex  =0;
        Student MaxStudentAge = list.get(0);
        for(int i = 0;i<list.size();i++){
            Student s= list.get(i);
            if(s.getAge()>MaxStudentAge.getAge()){
                MaxStudentAge = s;
                MaxStudentIndex = i;
            }
        }

        list.get(MaxStudentIndex).setName("天才");

        for (Student list2 : list) {
            System.out.println(list2);
        }

    }
}
