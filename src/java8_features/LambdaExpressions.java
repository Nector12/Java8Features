package java8_features;

/**
 * Facilitate functional programming
 * Syntax: parameter -> expression_body
 * <p>
 * Optional type declaration. It is infered by the compiler
 * Optional paranthesis around single parameter, required for multiple parameters.
 * Optional curly bracers for a sungle statement, required for multiple.
 * Optional return keyword.
 */
public class LambdaExpressions {

    final private static String salutation = "Hello! "; // Lambada expressions can refer to static variable

    public static void main(String[] args) {

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b; // return a + b

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b; // return a - b

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { // return a * b
            return a * b;
        };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b; // return a / b

        LambdaExpressions lambdaExpressions = new LambdaExpressions();

        System.out.println("10 + 5 = " + lambdaExpressions.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaExpressions.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaExpressions.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaExpressions.operate(10, 5, division));

        //with parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println(salutation + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");

    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
