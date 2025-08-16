package work6;

public class Factory {
    private Factory() {
    }

    public static Car getInstance(String name) {
        Car car = null;
        if (name.equals("Falali")) {
            car = new Falali();
        } else if (name.equals("Baoma")) {
            car = new Baoma();
        } else {
            return null;
        }
        return car;
    }
}
