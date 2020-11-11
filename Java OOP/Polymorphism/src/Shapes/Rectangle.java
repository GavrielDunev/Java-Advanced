package Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
    }

    public Double getHeight() {
        return this.height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.getPerimeter() == null) {
            super.setPerimeter(2 * this.height + 2 * this.width);
        }
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (super.getArea() == null) {
            super.setArea(this.height * this.width);
        }
        return super.getArea();
    }
}
