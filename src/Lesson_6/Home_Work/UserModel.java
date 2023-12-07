package Lesson_6.Home_Work;

public abstract class UserModel implements SendMessage {
    private String name;
    private String uri;
    static int count = 1;
    private int id;

    public UserModel(String name) {
        this.name = name;
        this.uri = "@" + name;
        this.id = count;
        count++;
    }

    public UserModel() {
        this("Anonymous" + String.valueOf(count));
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public int getId() {
        return id;
    }
}
