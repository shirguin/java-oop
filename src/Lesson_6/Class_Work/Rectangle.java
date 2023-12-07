package Lesson_6.Class_Work;

public class Rectangle extends Shape {
    private final double sideA;
    private final double sideB;

    public Rectangle(double a, double b) {
        this.sideA = a;
        this.sideB = b;
        super.name = ShapeName.RECTANGLE;
        CalcArea();
    }

    @Override
    public void CalcArea() {
        super.area = sideA * sideB;
    }

    @Override
    public String toString() {
        return String.format("Rectangle{sideA=%.2f; sideB=%.2f; area=%.2f}", sideA, sideB, area);
    }
}
