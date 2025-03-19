package example8;

public class Dog implements Animal{
    public void cry(){
        System.out.println("狗狗汪汪叫");
    }
    public String getAnimalName() {
        return "我是狗狗";
    }
}
