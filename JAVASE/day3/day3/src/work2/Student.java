package work2;

public class Student {
    private String name;
    private int age;
    private String sex;
    private String id;
    private String grade;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Student() {
    }
    public Student(String name, int age, String sex, String id, String grade) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = id;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex + ", id=" + id + ", grade=" + grade + "]";
    }


    
}
