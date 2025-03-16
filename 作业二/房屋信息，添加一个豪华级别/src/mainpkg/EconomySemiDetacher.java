package mainpkg;

public class EconomySemiDetacher implements SemiDetacher
{
    private String name;

    public EconomySemiDetacher(String sName)
    {
        name = sName;
    }

    public String getSemiDetacherInfo()
    {
        return "economySemiDetacher.html";
    }

    public String getSemiDetacherFeatures()
    {
        return "Economy SemiDetacher "+name;
    }

}
