package Lesson_5.Class_Work;

public class LinkData {

    private static Long id;
    Link link;

    public LinkData(Link link) {
        this.link = link;
        id++;
    }

    public static Long getId() {
        return id;
    }
}