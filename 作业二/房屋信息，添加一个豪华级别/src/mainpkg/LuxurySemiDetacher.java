package mainpkg;
public class LuxurySemiDetacher implements SemiDetacher{
    private String name;
    public LuxurySemiDetacher(String sName){
        name = sName;
    }
    public String getSemiDetacherInfo(){
        return "luxurySemiDetacher.html";
    }
    public String getSemiDetacherFeatures(){
        return "Luxury SemiDetacher "+name;
    }

}
