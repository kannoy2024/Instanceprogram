package interfaceAndExtend;

public class uiTeacher extends Employee implements drew {

    public uiTeacher() {
        super();
    }

    public uiTeacher(String name, int age, String sex) {
        super(name, age, sex);
    }



    @Override
    public void work() {
       System.out.println("uiTeacher 在工作");
        
    }

    @Override
    public void draw() {
       System.out.println("uiTeacher 会画画");
        
    }

}
