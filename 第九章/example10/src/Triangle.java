public class Triangle {
    double sideA;
    double sideB;
    double sideC;
    double area;
    boolean isTriangle;
    public double getArea() {
        if(isTriangle){
            double p=(sideA+sideB+sideC)/2;
            area=Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
            return area;
        }else{
            area = Double.NaN;
            return area;
        }
    }//very foolish code to determine if it is a triangle
    public void setSideA(double sideA){
        this.sideA=sideA;
        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA){
            isTriangle=true;
        }else{
            isTriangle=false;
        }
    }
    public void setSideB(double sideB){
        this.sideB=sideB;
        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA){
            isTriangle=true;
        }else{
            isTriangle=false;
        }
    }
    public void setSideC(double sideC){
        this.sideC=sideC;
        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA){
            isTriangle=true;
        }else{
            isTriangle=false;
        }
    }
}
