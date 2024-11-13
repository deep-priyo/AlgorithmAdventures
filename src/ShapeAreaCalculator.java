
class Shape {

    public double calculateArea() {
        System.out.println("Calculating area of a shape");
        return 0;
    }
}


class Rectangle extends Shape {
    private double length;
    private double width;


    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}


class Circle extends Shape {
    private double radius;

    // Constructor for Circle
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}


class Triangle extends Shape {
    private double base;
    private double height;


    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[3];


        shapes[0] = new Rectangle(10, 5);
        shapes[1] = new Circle(7);
        shapes[2] = new Triangle(8, 6);


        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}
