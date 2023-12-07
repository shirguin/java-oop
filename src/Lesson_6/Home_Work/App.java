package Lesson_6.Home_Work;

import java.util.Optional;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("1: Add user; 2: Remove user; 3: Update messages list; 4: Choose user to operate with messages");
            String choice = sc.nextLine();
            switch (choice) {
                case ("1") -> addUserProcedure();
                case ("2") -> removeUserProcedure();
                case ("3") -> MessageRepository.updateMsgList();
                case ("4") -> chooseUserProcedure();
                default -> System.out.println("Incorrect input!");
            }
        }
    }

    public Optional<Integer> tryParseInt(String toParse) {
        try {
            return Optional.of(Integer.parseInt(toParse));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    private void addUserProcedure() {
        UserRepository.updateUserList();
        System.out.println("Input user name or leave this field empty for Anonymous and press ENTER:");
        String name = sc.nextLine();
        System.out.println("What type of user it would be?\n1. Regular; 2. Super; 3. VIP:");
        String type = sc.nextLine();
        switch (type) {
            case ("1") -> UserRepository.addUser(new RegularUser(name));
            case ("2") -> UserRepository.addUser(new SuperUser(name));
            case ("3") -> UserRepository.addUser(new VIPUser(name));
            default -> System.out.println("Wrong input! Caution! Caution!");
        }
    }

    private void removeUserProcedure() {
        UserRepository.updateUserList();
        System.out.println("Input userID you want to delete: ");
        String id = sc.nextLine();
        tryParseInt(id).ifPresent(v -> UserRepository.removeUserByID(tryParseInt(id).get()));
    }

    private void chooseUserProcedure() {
        UserRepository.updateUserList();
        System.out.println("Input ID of user to operate: ");
        String i = sc.nextLine();
        Optional<Integer> op = tryParseInt(i);
        op.ifPresentOrElse(
                v -> Operate.start(op.get()),
                () -> System.out.println("Input error!"));
    }
}