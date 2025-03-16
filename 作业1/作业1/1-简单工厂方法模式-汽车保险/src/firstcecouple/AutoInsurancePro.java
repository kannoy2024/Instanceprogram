package firstcecouple;

public class AutoInsurancePro {
	public static final String BODYINJURE = "Body Injur Liability";
	public static final String COLLISION = "Collision Coverage";
	public static final String PERSONINJURE = "Personal Injury Protection";
	public static final String COMP="Comprehensive Protection";
	public static final String RentalReimbursement="RentalReimbursement";
	
	public String getInsuranceInfo(String type) {
		String result="";
		if(type.equals(BODYINJURE)) {
			result = " Body Injur Liability: \n\nBodily injury coverage pays for medical bills"
					+ " lost wages, rehabilitation, treatment and/or"
					+ " funeral costs for anyone injured or killed "
					+ " by your car. Such coverage will also pay for"
					+ " pain and suffering damages when a third " + " party successfully sues. ";
		}
		else if(type.equals(COLLISION))
		{
			result = "Collision Coverage: \n\nPays for damage to your car, less"+
		                 "any deductible, no matter who is at"+
		                 "fault. If your car is financed, your"+
		                 "lender may require you to buy this coverage"+
		                 "and may even require a particular deductible amount.";
		}
		else if(type.equals(PERSONINJURE))
		{
			result = "Personal Injury Protection \n\nPays medical expenses and some percentage"+
		                "of lost wages to you or anyone authorized"+
		                "to drive your car, no matter who caused the accident.";
		}
		else if(type.equals(COMP))
		{
			result = "COMP of lost wages to you or anyone authorized"+
		                "to drive your car, no matter who caused the accident.";
		}
		else if (type.equals(RentalReimbursement))
		{
			result = "Reimburses up to a specified amount per day for car rental "+
			"or transportation costs while your car is being repaired following an accident. ";
		}
		return result;//每当增加的时候都要修改这里，不符合对扩展开放，对修改关闭
	}
}
