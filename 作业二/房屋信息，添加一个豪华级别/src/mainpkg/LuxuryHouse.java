package mainpkg;
public class LuxuryHouse implements House{
    private String name;
    public LuxuryHouse(String hName){
        name = hName;
    }
    public String getHouseInfo(){
        return "luxuryHouse.html";
    }
    public String getHouseFeatures(){
        return "Luxury House "+name;
    }

}
