package Lesson_4.Home_Work;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        App app = new App(new View(), new ImportService(), new ExportService(), new AddRemoveService());
        app.start();
    }
}
