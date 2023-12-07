package Lesson_3.Class_Work;

import java.util.ArrayList;
import java.util.List;

public class PersonTree {
    List<Person> tree = new ArrayList<>();

    public List<Person> getTree() {
        return tree;
    }

    public void addPerson(Person person) {
        tree.add(person);
    }

    public void removePerson(Person person) {
        tree.remove(person);
    }

    @Override
    public String toString() {
        String str = new String();
        for (Person el :
                tree) {
            System.out.println(el);
        }
        return str;
    }
}
