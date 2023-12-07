package Lesson_4.Home_Work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ImportFromCSV {

    public ImportFromCSV(File fName) {
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(fName)))) {

            while (reader.hasNext()) {
                String str = reader.nextLine();
                if (!str.equals("\n")) {
                    String[] stringArray = str.split(";");
                    LocalDate createDate = LocalDate.parse(stringArray[0]);
                    LocalTime createTime = LocalTime.parse(stringArray[1]);
                    LocalDate deadline = LocalDate.parse(stringArray[2]);
                    String author = stringArray[3];
                    String description = stringArray[4];
                    TaskTree.add(new Task(createDate, createTime, deadline, author, description));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}