package Lesson_5.Home_Work;

public class SuperUser extends RegularUser implements SendMessage, DeleteMessage {
    MessageModel messageModel;

    public SuperUser(String name) {
        super(name);
    }

    public SuperUser() {
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
        return "*" + super.getName();
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


}
