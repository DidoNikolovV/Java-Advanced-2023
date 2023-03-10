package _02_Shapes;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    double calculateArea() {
        return height * width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
