package mainpkg;
public class EconomyBuildingFactory extends BuildingFactory {
   public House getHouse(){
	   return new EconomyHouse("Economy house");
   }
   public Condo getCondo(){
	   return new EconomyCondo("Economy condo");
   }
   public SemiDetacher getSemiDetacher(){
      return new EconomySemiDetacher("Economy semi-detacher");
   }
} // End of class
