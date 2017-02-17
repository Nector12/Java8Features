package nector;

/**
 * In java 8 interfaces can have default methods, methods with code.
 */
public class DefaultMethods {

    public static void main(String[] args) {
        Car car = new Car();
        car.description();
        car.startEngine();
    }

}

class Car implements Vehicle, FourWheeler {

    // We have to override the method description because it is inherited from two different interfaces.
    @Override
    public void description() {
        System.out.println("I'm a four wheeled vehicle!!");
    }
}

interface Vehicle {

    default void startEngine() {
        System.out.println("Bruuuuum!!!");
    }

    default void description() {
        System.out.println("I'm a vehicle");
    }
}

interface FourWheeler {
    default void description() {
        System.out.println("I'm a four wheeler!");
    }
}