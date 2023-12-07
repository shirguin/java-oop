package Lesson_6.Class_Work;

import java.util.Optional;
import java.util.Scanner;

public class Validator {
    Scanner sc = new Scanner(System.in);

    public void type() {
        String shapeNumber = sc.nextLine();
        switch (shapeNumber) {
            case ("1") -> checkForCircle();
            case ("2") -> checkForSquare();
            case ("3") -> checkForRectangle();
            case ("4") -> checkForTriangle();
            case ("5") -> checkForEllipse();
            case ("6") -> ShapeRepository.print();
            default -> System.out.println("Error!");
        }
    }

    private void checkForEllipse() {
        Optional<Double> smallAxle = getSize("small Axle");
        Optional<Double> bigAxle = getSize("big Axle");
        if (smallAxle.isPresent() && bigAxle.isPresent()) {
            ShapeRepository.add(new Ellipse(bigAxle.get(), smallAxle.get()));
        }
    }

    private void checkForTriangle() {
        Optional<Double> a = getSize("side A");
        Optional<Double> b = getSize("side B");
        Optional<Double> c = getSize("side C");
        if (a.isPresent() && b.isPresent() && c.isPresent()) {
            double q = a.get();
            double w = b.get();
            double e = c.get();
            if ((q + w > e) && (q + e > w) && (e + w > q)) {
                ShapeRepository.add(new Triangle(q, w, e));
            } else {
                System.out.println("This is not a triangle");
            }
        } else {
            System.out.println("Incorrect input");
        }
    }

    public void checkForCircle() {
        Optional<Double> radius = getSize("radius");
        radius.ifPresentOrElse(
                v -> ShapeRepository.add(new Circle(radius.get())),
                () -> System.out.println("Incorrect input")
        );
    }

    public void checkForSquare() {
        Optional<Double> side = getSize("side of square");
        side.ifPresentOrElse(
                v -> ShapeRepository.add(new Square(side.get())),
                () -> System.out.println("Incorrect input")
        );
    }

    public void checkForRectangle() {
        Optional<Double> sideA = getSize("side A");
        Optional<Double> sideB = getSize("side B");
        if (sideA.isPresent() && sideB.isPresent()) {
            ShapeRepository.add(new Rectangle(sideA.get(), sideB.get()));
        } else {
            System.out.println("Incorrect input");
        }
    }

    public Optional<Double> getSize(String text) {
        try {
            System.out.printf("Input %s:", text);
            double d = Double.parseDouble(sc.nextLine());
            if (d > 0) {
                return Optional.of(d);
            } else {
                return Optional.empty();
            }
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
