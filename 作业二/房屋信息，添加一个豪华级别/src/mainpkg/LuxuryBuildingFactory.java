package mainpkg;

public class LuxuryBuildingFactory extends BuildingFactory {
    public House getHouse() {
        return new LuxuryHouse("Luxury house");
    }
    public Condo getCondo() {
        return new LuxuryCondo("Luxury condo");
    }
    public SemiDetacher getSemiDetacher() {
        return new LuxurySemiDetacher("Luxury semi-detacher");
    }

}
