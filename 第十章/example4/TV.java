package example4;

import java.io.Serializable;

public class TV  implements Serializable{
    String name;
    int price;
    public void setName(String name) {
        this.name = name;
    }
    public void setPice(int price){
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getPice(){
        return price;
    }
}
