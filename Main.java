//Step 1: Create a shared resource class that needs to be accessed by multiple threads. In this example, let's create a class called Counter that has a method to increment its value.

class Counter {
    private int count = 0;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
    }

    // Method to get the current count
    public int getCount() {
        return count;
    }
}


Step 2: Create a Runnable implementation that will be executed by multiple threads. This class will use the shared resource (Counter) and perform some operations on it.

class MyRunnable implements Runnable {
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

Step 3: Create the main class where you will create multiple threads and start them to execute the Runnable tasks.

public class Main {
    public static void main(String[] args) {
        // Create a shared Counter object
        Counter counter = new Counter();

        // Create multiple threads
        Thread thread1 = new Thread(new MyRunnable(counter));
        Thread thread2 = new Thread(new MyRunnable(counter));

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final Count: " + counter.getCount());
    }
}
