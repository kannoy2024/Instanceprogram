package example5;

public class Cat extends Animal{
    private String name;
    public Cat() {
        this.name = "猫";
    }
    public void cry() {
        System.out.println("听好了，这个是猫叫·");
    }
    public String getAnimalName() {
        return name;    
    }

}
