package Lesson_6.Class_Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShapeRepository {
    private static final List<Shape> shapes = new ArrayList<>();

    public static void add(Shape shape) {
        shapes.add(shape);
        System.out.printf("Shape added: %s\n", shape);
    }

    public static Optional<Shape> getById(int id) {
        return Optional.of(shapes.get(id));
    }

    public static int length() {
        return shapes.size();
    }

    public static void print() {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
