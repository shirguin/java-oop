package Lesson_6.Class_Work;

public abstract class Shape {
    protected ShapeName name;
    protected double area;

    public ShapeName getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public abstract void CalcArea();

}
