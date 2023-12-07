package Lesson_5.Home_Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static List<RegularUser> userList = new ArrayList<>();

    public static List<RegularUser> getUserList() {
        return userList;
    }

    public static Optional<Integer> getIndexUserByID(int ID) {
        Optional<Integer> result = Optional.empty();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == ID) {
                result = Optional.of(i);
                break;
            }
        }
        return result;
    }

    public static Optional<RegularUser> getUserByID(int ID) {
        Optional<RegularUser> result = Optional.empty();
        if (getIndexUserByID(ID).isPresent()) {
            result = Optional.of(userList.get(getIndexUserByID(ID).get()));
        }
        return result;
    }

    public static void addUser(RegularUser user) {
        userList.add(user);
        System.out.printf("User added: %s\n", user.toString());
    }

    public static void removeUserByID(int ID) {
        if (getIndexUserByID(ID).isPresent()) {
            int index = getIndexUserByID(ID).get();
            userList.remove(index);
        }
    }

    public static void updateUserList() {
        for (RegularUser user : userList) {
            System.out.println(user);
        }
    }


}
