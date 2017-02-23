package java8_features;

import java.util.Arrays;
import java.util.List;

/**
 * PARALLEL STREAMS
 * Essentially, concurrent streams
 */
public class ParallelStreams {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //get count of empty string
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("# empty strings: " + count);

    }

}
