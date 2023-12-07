package Lesson_6.Class_Work;

public class Ellipse extends Shape {
    private final double bigAxle;
    private final double smallAxle;

    public Ellipse(double bigAxle, double smallAxle) {
        this.bigAxle = bigAxle;
        this.smallAxle = smallAxle;
        super.name = ShapeName.ELLIPSE;
        CalcArea();
    }

    @Override
    public void CalcArea() {
        super.area = Math.PI * this.bigAxle * this.smallAxle;
    }

    @Override
    public String toString() {
        return String.format("Ellipse{bigAxle=%.2f; smallAxle=%.2f; area=%.2f}", bigAxle, smallAxle, area);
    }
}
