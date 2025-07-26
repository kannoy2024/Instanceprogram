package Charge;

public class Taxi implements Charge{

    @Override
    public void charge() {
      System.out.println("出租车收费");
    }
    
}
