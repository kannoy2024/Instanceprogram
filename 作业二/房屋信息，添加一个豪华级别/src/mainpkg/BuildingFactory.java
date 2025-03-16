package mainpkg;

public abstract class BuildingFactory {
	public static final String LUXURY = "豪华级别";
	public static final String SUPER = "高级级别";
	public static final String MEDIUM = "中等级别";
	public static final String ECONOMY = "经济级别";

	public abstract House getHouse();//三个抽象方法，要在各自的子类中实现，比如《豪华房屋建造工厂类》里面
	public abstract Condo getCondo();
	public abstract SemiDetacher getSemiDetacher();

	public static BuildingFactory getBuildingFactory(String type) 
	{
		if (type.equals(BuildingFactory.LUXURY))
			return new LuxuryBuildingFactory();//豪华级别

		if (type.equals(BuildingFactory.SUPER))//应该把super改成高级级别但是我太懒了。就当super是senior吧
			return new SuperBuildingFactory();

		if (type.equals(BuildingFactory.MEDIUM))
			return new MediumBuildingFactory();

		if (type.equals(BuildingFactory.ECONOMY))
			return new EconomyBuildingFactory();

		System.out.println("我靠你是怎么选到这个的");
		return null;
	}

} // End of class
