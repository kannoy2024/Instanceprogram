package work1;

public class Company implements Money {

    private double money;

    public Company() {
    }

    public Company(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    @Override
    public void pay(Employee employee) {
    System.out.println("公司给员工" + employee.getName() + "支付了" + employee.getSalary());
    this.money -= employee.getSalary();
        
    }

}
