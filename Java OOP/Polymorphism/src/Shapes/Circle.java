package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.getPerimeter() == null) {
            super.setPerimeter(2 * Math.PI * this.radius);
        }
        return super.getPerimeter();
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculateArea() {
        if (super.getArea() == null) {
            super.setArea(Math.PI * this.radius * this.radius);
        }
        return super.getArea();
    }
}
