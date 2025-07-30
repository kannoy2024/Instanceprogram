package work1;

public class Manager extends Employee{
    public Manager() {
    	super();
    }
    public Manager(String name, double salary) {
    	super(name, salary);
    }
    public void pay(Employee employee) {
    	System.out.println("Manager " + employee.getName() + " gets " + employee.getSalary());
    }
}
