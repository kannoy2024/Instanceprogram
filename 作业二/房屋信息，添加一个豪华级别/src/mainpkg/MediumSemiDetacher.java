package mainpkg;

public class MediumSemiDetacher implements SemiDetacher
{
    private String name;

    public MediumSemiDetacher(String sName)
    {
        name = sName;
    }

    public String getSemiDetacherInfo()
    {
        return "mediumSemiDetacher.html";
    }

    public String getSemiDetacherFeatures()
    {
        return "Medium SemiDetacher "+name;
    }

}
