package mainpkg;

public class LuxuryCondo  implements Condo
{
    private String name;
    public LuxuryCondo(String cName){
  		name = cName;
    }
    public String getCondoInfo(){
        return "luxuryCondo.html";
    }
    public String getCondoFeatures(){
        return "Luxury Condo "+ name;
	}

}
