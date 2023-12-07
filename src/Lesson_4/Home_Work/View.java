package Lesson_4.Home_Work;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public String getValue() {
        System.out.println("1-previous task; 2-next task; 3-add/remove task, 4-update tasks list; 5-import tasks list; 6-export tasks list");
        System.out.print("Input your choice:");
        return sc.next();
    }

    public void print(Task task, int priority) {
        System.out.print("\033[H\033[J");//Почему-то не работает. Должна очиститься консоль и курсор переведен на первую строку.
        System.out.println("======================================================");
        System.out.printf("Priority (0 - the highest): %d\n", priority);
        System.out.printf("Task ID: \t\t\t\t\t%d\n", task.getId());
        System.out.printf("Days to Deadline: \t\t\t%s\n", task.getDeadline().toEpochDay() - LocalDate.now().toEpochDay());
        System.out.printf("Deadline: \t\t\t\t\t%s\n", task.getDeadline());
        System.out.printf("Date of creations: \t\t\t%s\n", task.getCreateDate());
        System.out.printf("Time of creations: \t\t\t%s\n", task.getCreateTime());
        System.out.printf("Author of task: \t\t\t%s\n", task.getAuthor());
        System.out.printf("Description: \t\t\t\t%s\n", task.getTaskDescription());
        System.out.println("======================================================");
    }
}
