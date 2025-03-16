public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("北方农场生产的蔬菜和水果: ");//北方工厂生产的蔬菜和水果
        NorthernGardener northernGardener = new NorthernGardener();
        Veggie northernVeggie = northernGardener.createVeggie("白菜");
        System.out.println(northernVeggie.getName());

        Fruit northernFruit = northernGardener.createFruit("苹果");
        System.out.println(northernFruit.getName());

        System.out.println("热带农场生产的蔬菜和水果: ");
        TropicalGardener tropicalGardener = new TropicalGardener();
        Veggie tropicalVeggie = tropicalGardener.createVeggie("甜瓜");
        System.out.println(tropicalVeggie.getName());

        Fruit tropicalFruit = tropicalGardener.createFruit("香蕉");
        System.out.println(tropicalFruit.getName());
        //水果类生产水果，蔬菜类生产蔬菜。
        //如果是北方水果，或者热带蔬菜。
        //抽象工厂就可以创建一组相关或相互依赖的对象。
        //
    }
}