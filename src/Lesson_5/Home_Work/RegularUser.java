package Lesson_5.Home_Work;

import java.util.Scanner;

public class RegularUser extends UserModel implements SendMessage {
    MessageModel messageModel;

    public RegularUser(String name) {
        super(name);
    }

    public RegularUser() {
        super();
    }

    @Override
    public void sendMessage(UserModel user, String message) {
        messageModel = new MessageModel();
        String msgText = messageModel.getMessage(this, user, message);
        MessageRepository.addMsg(new Message(msgText, messageModel.getMsgID()));
    }

    @Override
    public String nameForMessage() {
        return " " + super.getName();
    }

    @Override
    public String toString() {
        return String.format("Name: %s URI: %s usrID:%d", super.getName(), super.getUri(), super.getId());
    }
}
