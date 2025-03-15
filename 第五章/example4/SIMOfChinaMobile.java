package example4;

public class SIMOfChinaMobile extends SIM {
    private String number;
    public void SetNumber(String number) {
        this.number = number;
    }
    public String GetNumber() {
        return number;
    }
    public String GetCorpName() {
        return "中国移动";
    }
}
