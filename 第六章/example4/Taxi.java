package example4;

public class Taxi extends MotorVehicles implements ControlTemperature,MoneyFare{
    public void brake(){
        System.out.println("这辆的士使用脚刹");
    }
    public void charge() {
        System.out.println("这辆的士收比特币");
    }
    public void controlAirTemperature() {
        System.out.println("出租车使用核能空调");
    }
}
