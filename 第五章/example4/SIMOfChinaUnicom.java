package example4;

public class SIMOfChinaUnicom extends SIM {
    private String number;
    public void SetNumber(String number) {
        this.number = number;
    }
    public String GetNumber() {
        return number;
    }
    public String GetCorpName() {
        return "中国联通";
    }
}
