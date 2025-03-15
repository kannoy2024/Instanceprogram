package example3;
public class example3 {
    public static void main(String[] args) {
        Pillar pillar;
        Geometry bottom =null;
        pillar = new Pillar(bottom, 10);
        System.out.println("底面积为0，高为10的柱体体积为："+pillar.GetVolume());
        bottom = new Rectangle(12,22);
        pillar = new Pillar(bottom, 10);
        System.out.println("底面积为12*22，高为10的柱体体积为："+pillar.GetVolume());
        Circle circle = new Circle(10);
        pillar = new Pillar(circle, 10);
        System.out.println("底面积为10*10*3.14，高为10的柱体体积为："+pillar.GetVolume());
    }
}
