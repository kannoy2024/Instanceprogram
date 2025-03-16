package mainpkg;

public class MediumBuildingFactory extends BuildingFactory {
   public House getHouse() {
	   return new MediumHouse("Medium house");
   }
   public Condo getCondo() {
	   return new MediumCondo("Medium condo");
   }
   public SemiDetacher getSemiDetacher() {
       return new MediumSemiDetacher("Medium semi-detacher");
   }

} // End of class
