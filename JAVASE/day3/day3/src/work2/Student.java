package work2;

public class Student {
    private String name;
    private int age;
    private double height;
    private boolean isMarried;
    private char sex;
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
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public boolean isMarried() {
        return isMarried;
    }
    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public Student() {
    }
    public Student(String name, int age, double height, boolean isMarried, char sex) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.isMarried = isMarried;
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", height=" + height + ", isMarried=" + isMarried + ", sex="
                + sex + ", getName()=" + getName() + ", getAge()=" + getAge() + ", getHeight()=" + getHeight()
                + ", isMarried()=" + isMarried() + ", getSex()=" + getSex() + ", toString()=" + super.toString() + "]";
    }
    
    
}
