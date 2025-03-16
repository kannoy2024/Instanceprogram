package mainpkg;



public class SuperHouse implements House
{
  		private String name;

  		public SuperHouse(String cName)
  		{
    			name = cName;
  		}

  		public String getHouseInfo()
  		{
			return "superHouse.html";
	    }

	    public String getHouseFeatures()
		{
			return "Super House "+ name;
  		}

} // End of class


