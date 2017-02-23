package java8_features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Method references help to point to methods by their names.
 * A method reference operator is :: (double colon)
 * Can be used to point to:
 * Static methods,
 * Instance methods,
 * Constructors: (ClassName::new)
 */
public class MethodReference {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);

        /************ SORT AN ARRAY OF PERSONS **********/

        List<Person> personList = Arrays.asList(
                new Person(18, "Xavi"),
                new Person(25, "Estirador"),
                new Person(10, "Selgio"),
                new Person(22, "Mañel"));

        /*
        This is the most basic solution using lambda

        Collections.sort(personList, (Person a, Person b) -> {
            return a.getName().compareTo(b.getName());
        });
        */

        // But the class Person already has a compareByName method, so let's use it
        /*
        Collections.sort(personList, (Person a, Person b) -> {
            return Person.compareByName(a, b);
        });
        */

        // Because the previous lambda expression invokes an existing method, it can be replaces for a method reference.
        Collections.sort(personList, Person::compareByName);
        System.out.println("This is the sorted list of Persons");
        personList.forEach(System.out::println);

    }

}

class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static int compareByName(Person a, Person b) {
        return a.name.compareTo(b.name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
