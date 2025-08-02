package work1;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        // 要编写排序规则
        // 按照年龄从小到大排序，如果年龄一样，则按照姓名首字母排序，如果姓名和年龄一样，我们认为是同一个学生对象，不存入
        int result = this.age - o.age;
        if (result == 0) {
            result = this.name.compareTo(o.name);
        }
        //规则返回只有正数，0，负数
        return result;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}
