package Lesson_5.Home_Work;

import java.util.Optional;
import java.util.Scanner;

public class Operate {
    private static Scanner sc = new Scanner(System.in);

    public static void start(int usrID) {
        RegularUser user;
        if (UserRepository.getUserByID(usrID).isPresent()) {
            user = UserRepository.getUserByID(usrID).get();
            System.out.printf("Selected user is:\n%s\n", user);
            getAction(user);
        } else {
            System.out.println("No such user!");
        }
    }

    public static void getAction(RegularUser user) {
        System.out.println("Select an action:");
        if (user instanceof VIPUser) {
            System.out.println("1: Send message; 2: Delete message; 3: Edit message");
            String str = sc.nextLine();
            switch (str) {
                case ("1") -> sendMessage(user);
                case ("2") -> deleteMessage(user);
                case ("3") -> editMessage(user);
                default -> System.out.println("Input Error");
            }
        } else if (user instanceof SuperUser) {
            System.out.println("1: Send message; 2: Delete message");
            String str = sc.nextLine();
            switch (str) {
                case ("1") -> sendMessage(user);
                case ("2") -> deleteMessage(user);
                default -> System.out.println("Input Error");
            }
        } else if (user instanceof RegularUser) {
            System.out.println("1: Send message");
            String str = sc.nextLine();
            if (str.equals("1")) {
                sendMessage(user);
            } else {
                System.out.println("Input Error!");
            }
        }
    }

    private static void editMessage(RegularUser user) {
        MessageRepository.updateMsgList();
        System.out.println("Input msgID to edit:");
        String id = sc.nextLine();
        if (tryParseInt(id)) {
            System.out.println(MessageRepository.getMessageById(Integer.parseInt(id)));
            System.out.println("Input new message :");
            String text = sc.nextLine();
            ((VIPUser) user).editMessage(Integer.parseInt(id), text);
        }
    }

    public static void deleteMessage(RegularUser user) {
        MessageRepository.updateMsgList();
        System.out.println("Type messageID you want to delete: ");
        String str = sc.nextLine();
        if (tryParseInt(str)) {
            if (MessageRepository.getIndexByID(Integer.parseInt(str)).isPresent()) {
                ((SuperUser) user).deleteMsg(Integer.parseInt(str));
            } else {
                System.out.println("No such message");
            }
        } else {
            System.out.println("Input Error!");
        }
    }

    public static void sendMessage(RegularUser user) {
        UserRepository.updateUserList();
        System.out.println("Select userID to whom will be sent message:");
        String id = sc.nextLine();
        if (tryParseInt(id)) {
            if (UserRepository.getUserByID(Integer.parseInt(id)).isPresent()) {
                System.out.println("Type your message: ");
                String message = sc.nextLine();
                user.sendMessage(UserRepository.getUserByID(Integer.parseInt(id)).get(), message);
            } else {
                System.out.println("No such user!");
            }
        }
    }

    public static boolean tryParseInt(String str) {
        try {
            int i = Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
