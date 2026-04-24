import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        FibonacciSequence sequence = new FibonacciSequence();
        Iterator<Integer> iterator = sequence.iterator();

        System.out.println("First 10 values of Fibonacci:");

        for (int i = 0; i < 10; i++) {
            System.out.print(iterator.next() + " ");
        }
    }
}
