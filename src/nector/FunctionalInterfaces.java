package nector;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Functional interfaces are interfaces with only one method.
 * They are a perfect target for lambda expressions and method reference.
 *
 * java.util.Function; Contains a lot of functional interfaces.
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Print all numbers");
        evaluate(integers, i -> true);

        System.out.println("\nPrint even numbers only");
        evaluate(integers, i -> i%2 == 0);

        System.out.println("\nPrint numbers greater than 5");
        evaluate(integers, i -> i > 5);

    }

    public static void evaluate(List<Integer> integers, Predicate<Integer> predicate) {
        for (Integer i : integers) {
            if (predicate.test(i))
                System.out.print(i + " ");
        }
    }

}

