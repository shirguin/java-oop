package Lesson_4.Home_Work;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AddRemoveService {
    Scanner sc = new Scanner(System.in);

    public void getChoice() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("1-Add task, 2-Remove task");
            switch (sc.next()) {
                case ("1") -> {
                    addTask();
                    repeatInput = false;
                }
                case ("2") -> {
                    removeTask();
                    repeatInput = false;
                }

                default -> System.out.println("Noup! That`s not correct! Try again");
            }
        }
    }

    private void removeTask() {
        boolean repeatInput = true;
        int id = -1;
        while (repeatInput) {
            System.out.println("Input ID of the task you wont to remove: ");
            try {
                id = sc.nextInt();
                if (TaskTree.getTaskById(id) != -1) {
                    repeatInput = false;
                    TaskTree.removeById(id);
                } else {
                    System.out.println("Invalid ID");
                }
            } catch (Exception ex) {
                System.out.println("Invalid ID");
            }

        }
    }

    public void addTask() {
        boolean repeatInput = true;
        String author;
        String description = new String();
        LocalDate deadline = LocalDate.now();
        while (repeatInput) {
            System.out.println("Input deadline date (YYYY-MM-DD):");
            try {
                deadline = LocalDate.parse(sc.nextLine());
                repeatInput = false;
            } catch (Exception ex) {
                System.out.println("Invalid date!!!");
            }
        }
        System.out.println("Input author of the task");
        author = sc.nextLine();
        System.out.println("Input description of the task");
        author = sc.nextLine();
        String time = String.valueOf(LocalTime.now().getHour()) + ":" + String.valueOf(LocalTime.now().getMinute());
        TaskTree.add(new Task(LocalDate.now(), LocalTime.parse(time), deadline, author, description));
    }
}
