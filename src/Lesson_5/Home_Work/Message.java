package Lesson_5.Home_Work;

public class Message {
    private String message;
    private int msgID;

    public Message(String message, int msgID) {
        this.message = message;
        this.msgID = msgID;
    }

    public String getMessage() {
        return message;
    }

    public int getMsgID() {
        return msgID;
    }

    @Override
    public String toString() {
        return message;
    }

    public void edit(String text) {
        this.message = text;
    }
}
