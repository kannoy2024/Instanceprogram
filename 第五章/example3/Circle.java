package example3;

public class Circle extends Geometry{
    double radius;
    Circle(double radius){ 
        this.radius= radius;
    }
    public double GetArea() {
        return 3.14*radius*radius;
    }
}
