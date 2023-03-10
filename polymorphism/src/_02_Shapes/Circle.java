package _02_Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * (radius * radius);
    }

    public final double getRadius() {
        return radius;
    }
}
