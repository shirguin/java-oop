package Lesson_6.Class_Work;

public class Circle extends Ellipse {
    private double radius;

    public Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
        super.name = ShapeName.CIRCLE;
    }

    @Override
    public String toString() {
        return String.format("Circle{radius=%.2f; area=%.2f}", this.radius, super.area);
    }
}
