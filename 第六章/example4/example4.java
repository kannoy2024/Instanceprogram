package example4;

public class example4 {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        Cinema cinema = new Cinema();
        MoneyFare fare;
        ControlTemperature temperature;
        fare = bus;
        bus.brake();
        fare.charge();
        fare = taxi;
        temperature = taxi;
        taxi.brake();
        fare.charge();
        temperature.controlAirTemperature();
        fare=cinema;
        temperature=cinema;
        fare.charge();
        temperature.controlAirTemperature();
    }
}
