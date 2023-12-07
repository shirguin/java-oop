package Lesson_5.Home_Work;

import java.util.Scanner;

public class App {
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1: Add user; 2: Remove user; 3: Update messages list; 4: Choose user to operate with messages");
            String choice = sc.nextLine();
            switch (choice) {
                case ("1") -> {
                    UserRepository.updateUserList();
                    System.out.println("Input user name or leave this field empty for Anonymous and press ENTER:");
                    String name = sc.nextLine();
                    System.out.println("What type of user it would be?\n1. Regular; 2. Super; 3. VIP:");
                    String type = sc.nextLine();
                    boolean repeatInput = true;
                    switch (type) {
                        case ("1") -> {
                            UserRepository.addUser(new RegularUser(name));
                            repeatInput = false;
                        }
                        case ("2") -> {
                            UserRepository.addUser(new SuperUser(name));
                            repeatInput = false;
                        }
                        case ("3") -> {
                            UserRepository.addUser(new VIPUser(name));
                            repeatInput = false;
                        }
                        default -> System.out.println("Wrong input! Caution! Caution!");

                    }

                }

                case ("2") -> {
                    UserRepository.updateUserList();
                    System.out.println("Input userID you want to delete: ");
                    String id = sc.nextLine();
                    if (tryParseInt(id)) {
                        int index = Integer.parseInt(id);
                        UserRepository.removeUserByID(index);
                    }
                }

                case ("3") -> MessageRepository.updateMsgList();

                case ("4") -> {
                    UserRepository.updateUserList();
                    System.out.println("Input ID of user to operate: ");
                    String i = sc.nextLine();
                    if (tryParseInt(i)) {
                        int id = Integer.parseInt(i);
                        Operate.start(id);
                    } else {
                        System.out.println("Input error!");
                    }
                }

            }
        }
    }

    public boolean tryParseInt(String toParse) {
        try {
            Integer i = Integer.getInteger(toParse);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
