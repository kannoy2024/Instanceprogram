package example5;

public class B implements ComputerAverage {
    public double average(double a, double b) {
        double average = 0.0;
        average= Math.sqrt(a * b);
        return average;
    }
}
