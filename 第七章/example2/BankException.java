public class BankException extends Exception {
    String message;
    public BankException(int m,int n ) {
        message = "入账资金"+m+"是负数或支出"+n+"是正数";
    }
    public String warnMess(){
        return message;
    }
}