package example4;

public class Cinema implements MoneyFare,ControlTemperature{
    public void charge(){
        System.out.println("电影院使用黄金缴费");
    }
    public void controlAirTemperature(){
        System.out.println("电影院使用冰川空调");
    }
}
