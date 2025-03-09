class Circle {
    private double radius;

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("半径必须为正数");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}