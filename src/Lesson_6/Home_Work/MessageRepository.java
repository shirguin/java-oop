package Lesson_6.Home_Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageRepository {
    private static final List<Message> messageList = new ArrayList<>();

    public static List<Message> getMessageList() {
        return messageList;
    }

    public static void addMsg(Message message) {
        messageList.add(message);
        System.out.println("Message was added:");
        System.out.println(message);
    }

    public static void rmMsgByID(Integer msgId) {
        Optional<Integer> probability = getIndexByID(msgId);
        if (probability.isPresent()) {
            int index = probability.get();
            messageList.remove(index);
        }
    }

    public static Optional<Integer> getIndexByID(int msgID) {
        int i = 0;
        while (i < messageList.size()) {
            if (msgID == messageList.get(i).getMsgID()) {
                return Optional.of(i);
            } else {
                i++;
            }
        }
        return Optional.empty();
    }

    public static Optional<Message> getMessageById(int msgID) {
        Optional<Integer> index = getIndexByID(msgID);
        if (index.isPresent()) {
            return Optional.of(messageList.get(index.get()));
        }
        return Optional.empty();
    }

    public static void updateMsgList() {
        StringBuilder builder = new StringBuilder();
        for (Message msg : messageList) {
            builder.append(msg).append("\n");
        }
        System.out.println(builder);
    }

    public static void editMsgById(int ID, String text) {
        if (getIndexByID(ID).isPresent()) {
            int index = getIndexByID(ID).get();
            System.out.printf("Message {%s} was edited on:\n", messageList.get(index).getMessage());
            messageList.get(index).edit(text);
            System.out.println(messageList.get(index).getMessage());
        } else {
            System.out.println("No such message");
        }
    }

}
