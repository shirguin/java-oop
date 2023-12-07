package Lesson_6.Home_Work;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message {
    private static int count = 1;
    private String message;
    private final UserModel fromUser;
    private final UserModel toUser;
    private final LocalDate msgDate;
    private final LocalTime msgTime;
    private final int msgID;

    public Message(UserModel fromUser, UserModel toUser, String message) {
        this.message = message;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.msgDate = LocalDate.now();
        this.msgTime = LocalTime.now();
        this.msgID = count++;
    }

    public String getMessage() {
        return message;
    }

    public int getMsgID() {
        return msgID;
    }

    public UserModel getFromUser() {
        return fromUser;
    }

    public UserModel getToUser() {
        return toUser;
    }

    public LocalDate getMsgDate() {
        return msgDate;
    }

    public LocalTime getMsgTime() {
        return msgTime;
    }

    public void edit(String text) {
        this.message = text;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("msgID: ").
                append(msgID).
                append("; ").
                append(msgDate).
                append(";").
                append(msgTime.getHour()).
                append(":").
                append(msgTime.getMinute()).
                append("; ").
                append("userID:").
                append(fromUser.getId()).
                append(", to userID: ").
                append(toUser.getId()).
                append(" - { ").
                append(fromUser.nameForMessage()).
                append(" send message to ").
                append(toUser.nameForMessage()).
                append(": ").
                append(message).
                append(" }");
        return builder.toString();
    }
}
