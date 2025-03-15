package example3;

public class Pillar {
    Geometry bottom;
    double height;
    Pillar(Geometry bottom, double height){
        this.bottom = bottom;
        this.height = height;
    }
    public double GetVolume() {
        if (bottom == null) {
           System.out.println("你小子怎么没有底的。");
            return 0;
        }else{
            return bottom.GetArea()*height;
        }
    }
}
