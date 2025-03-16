package mainpkg;

public class EconomyCondo implements Condo {
	private String name;

	public EconomyCondo(String cName) {
		name = cName;
	}

	public String getCondoInfo() {
		return "economyCondo.html";
	}

	public String getCondoFeatures() {
		return "Economy Condo "+name;
	}

	/*
	 * public String getCarName() { return name; }
	 * 
	 * public String getCarFeatures() { return "Luxury Car Features "; };
	 */

} // End of class