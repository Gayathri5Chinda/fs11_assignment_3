//There are two primary ways to implement abstraction in Java: 1)Abstract Classes 2)Interfaces

// Abstract class example
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void sound();
    
    // Concrete method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Interface example
interface Vehicle {
    // Abstract method 
    void drive();
    
    // Default method
    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

// Concrete class implementing abstract class and interface
class Dog extends Animal implements Vehicle {
    // Implementing abstract method from Animal class
    public void sound() {
        System.out.println("Woof");
    }
    
    
    public void drive() {
        System.out.println("Dog running");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // Output: Woof
        dog.sleep(); // Output: Zzz
        dog.drive(); // Output: Dog running
        dog.stop();  // Output: Vehicle stopped
    }
}
