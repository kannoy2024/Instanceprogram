package cn.edu.bbc.computer;
//添加椭球类
public class Ellipsoid implements GeoForm {
    private double a, b, c;

    public Ellipsoid(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double computeVolume() {
        return (4.0 / 3.0) * Math.PI * a * b * c;
    }
}