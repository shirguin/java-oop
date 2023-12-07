package Lesson_6.Home_Work;

public class Programm {
    public static void main(String[] args) {
        App app = new App();

        UserRepository.addUser(new RegularUser());
        UserRepository.addUser(new RegularUser());
        UserRepository.addUser(new SuperUser());
        UserRepository.addUser(new SuperUser());
        MessageRepository.updateMsgList();
        System.out.println(UserRepository.getUserByID(1).isPresent());
        System.out.println(UserRepository.getUserByID(2).isPresent());
        System.out.println(UserRepository.getUserByID(3).isPresent());
        System.out.println(UserRepository.getUserByID(4).isPresent());
        UserRepository.getUserByID(1).get().sendMessage(UserRepository.getUserByID(4).get(), "Hi!");
        System.out.println("\nChecking for messageList:");
        MessageRepository.updateMsgList();
        UserRepository.getUserByID(2).get().sendMessage(UserRepository.getUserByID(1).get(), "Will we going to the fishing tomorrow?");
        System.out.println("\nChecking for messageList:");
        MessageRepository.updateMsgList();
        UserRepository.getUserByID(3).get().sendMessage(UserRepository.getUserByID(1).get(), "Fuck off, asshole!");
        System.out.println("\nChecking for messageList:");
        MessageRepository.updateMsgList();
        UserRepository.getUserByID(4).get().sendMessage(UserRepository.getUserByID(3).get(), "You should be calmer");
        System.out.println("\nChecking for messageList:");
        MessageRepository.updateMsgList();

        ((SuperUser) UserRepository.getUserByID(3).get()).deleteMsg(3);
        MessageRepository.getMessageById(3).ifPresent(System.out::println);
        MessageRepository.updateMsgList();
        System.out.println("Demo was ended. You may try to add/remove users and send messages\n");

        app.start();

    }
}