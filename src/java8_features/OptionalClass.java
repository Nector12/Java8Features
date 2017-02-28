package java8_features;

import java.util.Optional;

/**
 * Created by nector on 23/02/17.
 */
public class OptionalClass {

    public static void main(String[] args) {

        OptionalClass optionalClass = new OptionalClass();
        optionalClass.optionalParam(Optional.ofNullable(15));
        optionalClass.optionalParam(Optional.ofNullable(null));

        Optional<String> string = optionalClass.optionalReturn(false);
        if (string.isPresent()) {
            System.out.println("Result not null");
        } else {
            System.out.println("Result null");
        }

    }

    /**
     * Passing a Optional as a parameter shouldn't be done.
     * This is just a example.
     *
     * @param optParam
     */
    private void optionalParam(Optional<Integer> optParam) {

        if (optParam.isPresent()) {
            System.out.println("You passed in a parameter");
        } else {
            System.out.println("The parameter is null");
        }

    }

    /**
     * @param b
     * @return a valid string if b == true, else null
     */
    private Optional<String> optionalReturn(boolean b) {

        return b ? Optional.of("This is a string") : Optional.empty();

    }

}
