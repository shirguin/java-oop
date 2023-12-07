package Lesson_4.Home_Work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToCSV {
    public ExportToCSV(File file) {

        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            for (Task task : TaskTree.getList()) {
                strBuilder.append(task.getCreateDate());
                strBuilder.append(";");
                strBuilder.append(task.getCreateTime());
                strBuilder.append(";");
                strBuilder.append(task.getDeadline());
                strBuilder.append(";");
                strBuilder.append(task.getAuthor());
                strBuilder.append(";");
                strBuilder.append(task.getTaskDescription());
                strBuilder.append("\n");
            }
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("UPS! Write error. Tasks wasn`t saved to disk. %s", e);
        }
    }
}
