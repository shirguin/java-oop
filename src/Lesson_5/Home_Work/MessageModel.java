package Lesson_5.Home_Work;

import java.time.LocalDate;
import java.time.LocalTime;

public class MessageModel {
    static int count = 1;
    private int msgID;

    public String getMessage(UserModel sender, UserModel receiver, String message) {
        msgID = count++;
        StringBuilder builder = new StringBuilder();
        builder.append("msgID: ").
                append(msgID).
                append("; ").
                append(LocalDate.now()).
                append(";").
                append(LocalTime.now().getHour()).
                append(":").
                append(LocalTime.now().getMinute()).
                append("; ").
                append("userID:").
                append(sender.getId()).
                append(", to userID: ").
                append(receiver.getId()).
                append(" - { ").
                append(sender.nameForMessage()).
                append(" send message to ").
                append(receiver.nameForMessage()).
                append(": ").
                append(message).
                append(" }");
        return builder.toString();
    }

    public int getMsgID() {
        return msgID;
    }
}
