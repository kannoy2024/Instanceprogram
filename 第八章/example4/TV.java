package example4;
public class TV {   
    double price;
    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        String oldStr = super.toString();
        return oldStr + " 这是电视机,他的价格是:" + price;
    }

}
