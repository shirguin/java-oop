package Lesson_4.Home_Work;

import java.io.File;
import java.util.Scanner;

public class ExportService {
    public String path = "./src/main/java/Lesson04/HomeWork/TaskList";
    Scanner sc = new Scanner(System.in);

    public void getChoice() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("Export to: 1-XML, 2-CSV, 3-JSON");
            switch (sc.next()) {
                case ("1") -> {
                    exportToXML();
                    repeatInput = false;
                }
                case ("2") -> {
                    exportToCSV();
                    repeatInput = false;
                }
                case ("3") -> {
                    exportToJSON();
                    repeatInput = false;
                }
                default -> System.out.println("Noup! That`s not correct! Try again");
            }
        }
    }

    public void exportToXML() {
        path += ".xml";
        ExportToXML exp = new ExportToXML(new File(path));
    }

    public void exportToCSV() {
        path += ".csv";
        ExportToCSV exp = new ExportToCSV(new File(path));
    }

    public void exportToJSON() {
        path += ".json";
        ExportToJSON exp = new ExportToJSON(new File(path));
    }
}