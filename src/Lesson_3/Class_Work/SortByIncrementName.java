package Lesson_3.Class_Work;

import java.util.Comparator;

public class SortByIncrementName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
