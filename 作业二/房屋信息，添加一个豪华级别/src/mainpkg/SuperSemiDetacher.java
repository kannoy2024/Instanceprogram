package mainpkg;

public class SuperSemiDetacher implements SemiDetacher
{
    private String name;

    public SuperSemiDetacher(String sName)
    {
        name = sName;
    }

    public String getSemiDetacherInfo()
    {
        return "superSemiDetacher.html";
    }

    public String getSemiDetacherFeatures()
    {
        return "Super SemiDetacher "+name;
    }

}
