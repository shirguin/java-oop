package Lesson_3.Class_Work;

import java.util.Collections;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        PersonTree tree = new PersonTree();
        tree.addPerson(new Person("Sergei", "Pavshin", 43));
        tree.addPerson(new Person("Egor", "Pavshin", 9));
        tree.addPerson(new Person("Natali", "Pavshina", 45));

        System.out.println(tree);

        tree.getTree().sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.printf("Sorted by anonymous method for increment age\n%s\n", tree);

        tree.getTree().sort((Person o1, Person o2) -> o2.getAge() - o1.getAge());
        System.out.printf("Sorted by lambda for decrement age\n%s\n", tree);

        Collections.sort(tree.getTree(), new SortByIncrementName());
        System.out.printf("Sorted by implement interface of new class for increment name\n%s\n", tree);

        Collections.sort(tree.getTree());
        System.out.printf("Sorted without explicit transfer comparator for decrement name\n%s\n", tree);
    }

}
