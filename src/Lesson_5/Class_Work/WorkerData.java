package Lesson_5.Class_Work;

public class WorkerData {
    private static Long id = 0l;
    Worker worker;

    public WorkerData(Worker worker) {
        this.worker = worker;
        id++;
    }

    public static Long getId() {
        return id;
    }
}
