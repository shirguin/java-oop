package Lesson_5.Home_Work;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageRepository {
    private static List<Message> messageList = new ArrayList<>();

    public static List<Message> getMessageList() {
        return messageList;
    }

    public static void addMsg(Message message) {
        messageList.add(message);
        System.out.println("Message was added:");
        System.out.println(message.getMessage());
    }

    public static void rmMsgByID(Integer msgId) {
        Optional<Integer> probability = getIndexByID(msgId);
        if (probability.isPresent()) {
            int index = probability.get();
            messageList.remove(index);
        }
    }

    public static Optional<Integer> getIndexByID(int msgID) {
        Optional<Integer> result = Optional.empty();
        int i = 0;
        while (i < messageList.size()) {
            if (msgID == messageList.get(i).getMsgID()) {
                result = Optional.of(i);
                break;
            } else {
                i++;
            }
        }
        return result;
    }

    public static String getMessageById(int msgID) {
        String msg = String.format("There`s no message with id: %d", msgID);
        Optional<Integer> index = getIndexByID(msgID);
        if (index.isPresent()) {
            msg = messageList.get(index.get()).getMessage();
        }
        return msg;
    }

    public static void updateMsgList() {
        StringBuilder builder = new StringBuilder();
        for (Message msg : messageList) {
            builder.append(msg.getMessage()).append("\n");
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
