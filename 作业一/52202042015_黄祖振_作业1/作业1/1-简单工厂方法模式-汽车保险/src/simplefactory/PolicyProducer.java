package simplefactory;


public class PolicyProducer{
	   public static final String BODYINJURE = "Body Injur Liability";
	   public static final String COLLISION = "Collision Coverage";
	   public static final String PERSONINJURE = "Personal Injury Protection";
	   public static final String COMP="Comprehensive Protection";
	   public static final String RentalReimbursement="RentalReimbursement";

   public static AutoInsurance getPolicyObj(String type){
      AutoInsurance policy = null;

	  if(type.equals(BODYINJURE)){//偶然内聚，还可以分解
	     policy = new BodyInjur();
	  }
	  else if(type.equals(COLLISION)){
	     policy = new Collision();
	  }
	  else if(type.equals(PERSONINJURE)){
		     policy = new PersonInjur();
	  }
	  else if(type.equals(COMP)){
	   	 policy = new Comprehensive();
	  }
	  else if(type.equals(RentalReimbursement)){
	   	 policy = new RentalReimbursement();
	  }
	  return  policy;//客户选中什么业务就返回什么，不会白白new 一个对象
    }
}
