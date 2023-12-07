package Lesson_6.Class_Work;

public class Program {
    public static void main(String[] args) {
        Validator validator = new Validator();
        while (true) {
            System.out.println("Input what type of shape do you want to add:\n" +
                    "1. CIRCLE; 2. SQUARE, 3. RECTANGLE; 4. TRIANGLE, 5. ELLIPSE, 6. Show me the list");
            validator.type();
        }

    }
}
