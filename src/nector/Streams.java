package nector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A stream represents a sequence of objects from a source, which supports aggregate operations.
 * Pipeline operations.
 * Stream operations do the iretations internally.
 */
public class Streams {

    public static void main(String[] args) {

        Streams streams = new Streams();

        streams.simpleExample();

        /** FOREACH
         * Stream has provided a new method ‘forEach’ to iterate each element of the stream.
         * **/
        streams.forEachExample();

        /** MAP
         * The ‘map’ method is used to map each element to its corresponding result.
         * **/
        streams.mapExample();


        /** FILTER
         * The ‘filter’ method is used to eliminate elements based on a criteria.
         * **/
        streams.filterExample();


        /** LIMIT
         * The ‘limit’ method is used to reduce the size of the stream.
         * This code creates a List of random integers.
         */
        streams.limitExample();

        /** SORTED
         * Used to sort the stream.
         */
        streams.sortedExample();

    }

    private void sortedExample() {

        System.out.println("Sorting streams");
        Random random = new Random();
        random.ints(10, 0, 100)
                .limit(10)
                .sorted()
                .forEach(System.out::println);

    }

    private void limitExample() {

        Random random = new Random();
        List<Integer> numbers = random.ints(0, 100)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        numbers.forEach(System.out::println);

    }

    private void filterExample() {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // This code counts the number of empty strings in the String list above.
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Number of empty strings: " + count);

    }

    private void mapExample() {

        List<Person> people = Arrays.asList(
                new Person("Selgio"),
                new Person("Mañel"),
                new Person("Lobelto"),
                new Person("Coles"),
                new Person("Planes"));

        // This stream maps the name of the Person in the list people in the new List<String>
        List<String> personsNames = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("\nPeople's names:");
        personsNames.forEach(System.out::println);

    }

    private void forEachExample() {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Before filtering:");
        strings.forEach(System.out::println);
        System.out.println("After filtering");
        filtered.forEach(System.out::println);

    }

    private void simpleExample() {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // This code 'iterates' over the collection and filters it.
        // For each string in the collection the filter checks if it is empty,
        // if it is not, it is 'added' to a result list
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

    }

    private static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
