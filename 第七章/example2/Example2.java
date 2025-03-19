public class Example2 {
    public static void main(String[] args) {
        Bank bank=new Bank();
        try{
            bank.income(200, -100);
            bank.income(650, -200);
            System.out.println("银行目前收入为:"+bank.getMoney()+"元");
            bank.income(0, -100);
            bank.income(0, -10000);
        }catch(BankException e){
            System.out.println("发生异常");
            System.out.println(e.warnMess());
        }
        System.out.println("银行目前收入为:"+bank.getMoney()+"元");
    }
}
