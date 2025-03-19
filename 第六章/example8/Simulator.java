package example8;

public class Simulator {
    public void playSound(Animal animal){
        animal.cry();
        System.out.println("我是"+animal.getAnimalName());
    }
}
