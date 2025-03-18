package example4;

public class Bus extends MotorVehicles implements MoneyFare,ControlTemperature {
    void brake(){
        System.out.println( "这辆公交车使用没有刹车");
    }
    public void charge() {
        System.out.println("上公交怎么还要缴费的");
    }
    public void controlAirTemperature() {
        System.out.println("公交车的空调坏了");
    }
}
