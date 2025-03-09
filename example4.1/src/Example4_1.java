public class Example4_1 {
public static void main(String[] args) {
    Rect r = new Rect();
    r.width = 3;
    r.height = 4;
    double area = r.getArea();
    System.out.println("面积是：" + area);
    Ladder l = new Ladder();
    l.above = 3;
    l.bettom = 2;
    l.height = 1.2;
    double area2 = l.getArea();
    System.out.println("面积是：" + area2);
}
}
