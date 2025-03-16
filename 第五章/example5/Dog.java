package example5;

public class Dog extends Animal {
    private String name;
    public Dog() {
        this.name = "狗";
    }
    public void cry(){
        System.out.println("妈的狗是怎么叫的");
    }
    public String getAnimalName() {
        return name;
    }
}
