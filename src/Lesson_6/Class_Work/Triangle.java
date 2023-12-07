package Lesson_6.Class_Work;

public class Triangle extends Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        super.name = ShapeName.TRIANGLE;
        CalcArea();
    }

    @Override
    public void CalcArea() {
        double p = (this.sideA + this.sideB + this.sideC) / 2;
        super.area = Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
    }

    @Override
    public String toString() {
        return String.format("Triangle{sideA=%.2f; sideB=%.2f; sideC=%.2f; area=%.2f}", sideA, sideB, sideC, area);
    }
}
