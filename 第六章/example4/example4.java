package example4;

public class example4 {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        Cinema cinema = new Cinema();
        MoneyFare fare;//接口变量fare
        ControlTemperature temperature;//接口变量temperature
        fare = bus;
        bus.brake();
        fare.charge();//接口变量回调bus类实现的charge方法
        fare = taxi;
        temperature = taxi;
        taxi.brake();
        fare.charge();//接口变量回调taxi类实现的charge方法
        temperature.controlAirTemperature();
        fare=cinema;
        temperature=cinema;
        fare.charge();
        temperature.controlAirTemperature();
    }
}
