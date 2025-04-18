public class Example4_2 {
    public static void main(String[] args) {
        try {
            Circle circle = new Circle();
            circle.setRadius(5.0);
            printCircleInfo(circle);

            CircularCylinder circularCylinder = new CircularCylinder();
            circularCylinder.setBottom(circle);
            circularCylinder.setHeight(10.0);
            printCylinderInfo(circularCylinder);
        } catch (IllegalArgumentException e) {
            System.err.println("输入参数无效: " + e.getMessage());
        }
    }

    private static void printCircleInfo(Circle circle) {
        System.out.println("半径为" + circle.getRadius() + "的圆的面积为" + circle.getArea());
    }

    private static void printCylinderInfo(CircularCylinder circularCylinder) {
        System.out.println("半径为" + circularCylinder.getBottomRadius() + "的圆柱的体积为" + circularCylinder.getVolume());
    }
}