package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4D, 5D);
        Shape circle = new Circle(7d);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}
