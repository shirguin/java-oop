package Lesson_4.Home_Work;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Task {
    private static int idCount = 0;
    private LocalDate createDate;
    private LocalTime createTime;
    private LocalDate deadline;
    private String author;
    private String taskDescription;
    private int id;

    public Task(LocalDate createDate, LocalTime createTime, LocalDate deadline, String author, String taskDescription) {
        this.createDate = createDate;
        this.createTime = createTime;
        this.deadline = deadline;
        this.author = author;
        this.taskDescription = taskDescription;
        this.id = ++idCount;

    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getAuthor() {
        return author;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        Period p = Period.between(LocalDate.now(), deadline);
        return "Task{" +
                "id=" + id +
                ", days to deadline=" + p.getYears() + "y:" + p.getMonths() + "m:" + p.getDays() +
                "d, createDate=" + createDate +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", Author='" + author + '\'' +
                ", Description='" + taskDescription + '\'' +
                '}';
    }
}
