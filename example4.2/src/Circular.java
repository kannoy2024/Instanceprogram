class CircularCylinder {
    private Circle bottom;
    private double height;

    public void setBottom(Circle bottom) {
        this.bottom = bottom;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("高度必须为正数");
        }
        this.height = height;
    }

    public double getBottomRadius() {
        return bottom.getRadius();
    }

    public double getVolume() {
        return bottom.getArea() * height;
    }
}