package Lesson_6.Home_Work;

public class RegularUser extends UserModel implements SendMessage {

    public RegularUser(String name) {
        super(name);
    }

    public RegularUser() {
        super();
    }

    @Override
    public void sendMessage(UserModel user, String message) {
        MessageRepository.addMsg(new Message(this, user, message));
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
