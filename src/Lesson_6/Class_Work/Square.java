package Lesson_6.Class_Work;

public class Square extends Rectangle {
    private double side;

    public Square(double a) {
        super(a, a);
        side = a;
        super.name = ShapeName.SQUARE;
    }

    @Override
    public String toString() {
        return String.format("Square{side=%.2f; area=%.2f}", side, area);
    }
}
