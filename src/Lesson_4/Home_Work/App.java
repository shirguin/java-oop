package Lesson_4.Home_Work;

public class App {
    View view;
    ImportService importService;
    ExportService exportService;
    AddRemoveService addRemoveService;
    private int currentTask = 0;

    public App(View view, ImportService imService, ExportService exService, AddRemoveService addRemoveService) {
        this.importService = imService;
        this.exportService = exService;
        this.view = view;
        this.addRemoveService = addRemoveService;
    }

    public void start() {
        while (true) {
            if (TaskTree.getList().size() > 0) {
                view.print(TaskTree.getTaskByPriority(currentTask), currentTask);
            }
            switch (view.getValue()) {
                case ("1"):
                    currentTask--;
                    if (currentTask < 0) {
                        currentTask = TaskTree.getList().size() - 1;
                    }
                    break;
                case ("2"):
                    currentTask++;
                    if (currentTask > TaskTree.getList().size() - 1) {
                        currentTask = 0;
                    }
                    break;
                case ("3"):
                    addRemoveService.getChoice();
                    currentTask = 0;
                    break;
                case ("4"):
                    TaskTree.update();
                    currentTask = 0;
                    break;
                case ("5"):
                    importService.getChoice();
                    break;
                case ("6"):
                    exportService.getChoice();
                    break;
                default:
                    System.out.println("That isn`t so number at menu");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }

}
