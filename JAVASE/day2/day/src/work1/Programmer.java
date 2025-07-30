package work1;

public class Programmer extends Employee implements Money {
    public Programmer() {
        super();
    }

    public Programmer(String name, double salary) {
        super(name, salary);
    }

    public void pay(Employee employee) {
        System.out.println("程序员" + employee.getName() + "的工资是" + employee.getSalary());
    }
}
