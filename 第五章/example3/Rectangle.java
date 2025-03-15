package example3;

public class Rectangle extends Geometry{
    double width;
    double height;
    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double GetArea() {
        return width*height;
    }
}
