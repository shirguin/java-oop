package Lesson_6.Home_Work;

public class VIPUser extends SuperUser implements EditMessage {

    public VIPUser(String name) {
        super(name);
    }

    public VIPUser() {
        super();
    }

    @Override
    public void sendMessage(UserModel user, String message) {
        MessageRepository.addMsg(new Message(this, user, message));
    }

    @Override
    public String nameForMessage() {
        return "!*!" + super.getName();
    }

    @Override
    public void deleteMsg(Integer msgID) {
        MessageRepository.rmMsgByID(msgID);
        System.out.printf("Message with ID: %d was deleted by user: %s\n", msgID, super.getName());
    }

    @Override
    public String toString() {
        return String.format("Name: %s URI: %s usrID:%d", super.getName(), super.getUri(), super.getId());
    }


    @Override
    public void editMessage(int msgID, String text) {
        MessageRepository.editMsgById(msgID, text);
    }
}
