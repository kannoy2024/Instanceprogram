package work6;

import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("bean");
        String name = rb.getString("name");
        Car car = Factory.getInstance(name);
        car.run();
    }

}
