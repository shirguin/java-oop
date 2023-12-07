package Lesson_3.Class_Work;

public class Person implements Comparable<Person> {
    private final String name;
    private final String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, age: %d", this.surname, this.name, this.age);
    }

    @Override
    public int compareTo(Person o) {
        return o.getName().compareTo(this.name);
    }
}
