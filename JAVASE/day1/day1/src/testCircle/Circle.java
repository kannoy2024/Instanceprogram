package testCircle;

public class Circle implements ShapePara {
    public static final double PI=3.14;

    public double radius;
    private double x;
    private double y;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

 

    public double  getRadius(){
        return radius;
    }   
    
    
    public Circle(double radius){
        this.radius=radius;
    }

    

    @Override
    public int getArea() {
     return (int) (Math.PI*radius*radius);
    }

    @Override
    public int getCircumference() {
        return (int) (2*Math.PI*radius);
    }

    public void setCenter(int x,int y){
    }

}
