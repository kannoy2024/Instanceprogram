package simplefactory;

public class RentalReimbursement implements AutoInsurance {//接口
   private String description;
	public String getInsurInfo() {
		description =" Reimburses up to a specified amount per day for car rental "
        +"or transportation costs while your car is being repaired following an accident. ";
	  return description;
	}
}
