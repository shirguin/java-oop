package Lesson_4.Class_Work;

public class Program {
    public static void main(String[] args) {
        ListAr<String> list = new ListAr<>(1);
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        list.add("d");
        System.out.println(list);
        list.add("e");
        System.out.println(list);
        list.add("f");
        System.out.println(list);
        System.out.println(list.getByIndex(2));
        list.removeByIndex(2);
        System.out.println(list);
        list.removeByElement("e");
        System.out.println(list);
        list.set(1, "z");
        System.out.println(list);
        System.out.println(list.indexOf("c"));
        ListAr<String> b = new ListAr<>();
        b.add("u");
        b.add("v");
        b.add("e");
        b.add("d");
        System.out.println(b);
        list.addAll(b);
        System.out.println(list);
        list.sort();
        System.out.println(list);
        list.removeAll(b);
        System.out.println(list);

    }
}
