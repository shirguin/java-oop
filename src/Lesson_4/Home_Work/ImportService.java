package Lesson_4.Home_Work;

import java.io.File;
import java.util.Scanner;

public class ImportService {
    Scanner sc = new Scanner(System.in);
    public String path = "./src/main/java/Lesson04/HomeWork/TaskList";

    public void getChoice() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("Import from: 1-XML, 2-CSV, 3-JSON");
            switch (sc.next()) {
                case ("1") -> {
                    importFromXML();
                    ;
                    repeatInput = false;
                }
                case ("2") -> {
                    importFromCSV();
                    repeatInput = false;
                }
                case ("3") -> {
                    importFromJSON();
                    repeatInput = false;
                }
                default -> System.out.println("Noup! That`s not correct! Try again");
            }
        }
    }

    public void importFromXML() {
        path += ".xml";
        ImportFromXML imp = new ImportFromXML(new File(path));
    }

    public void importFromCSV() {
        path += ".csv";
        ImportFromCSV imp = new ImportFromCSV(new File(path));
    }

    public void importFromJSON() {
        path += ".json";
        ImportFromJSON imp = new ImportFromJSON(new File(path));
    }
}
