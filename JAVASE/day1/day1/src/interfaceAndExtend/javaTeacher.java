package interfaceAndExtend;

public class javaTeacher extends Employee{

    public javaTeacher(){
    }

    public javaTeacher(String name,int age,String sex){
        super(name, age, sex);
    }

    @Override
    public void work() {
        System.out.println("javaTeacher 在工作");
    }




}
