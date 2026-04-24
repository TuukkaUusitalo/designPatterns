import java.util.Iterator;

/*
 * Two previous numbers are stored in the iterator
 * 1. Every iterator is independent from others
 * 2. It makes possible to generate Fibonacci numbers on demand
 */
public class FibonacciIterator implements Iterator<Integer> {

    private int previous = 0;
    private int current = 1;

    @Override
    public boolean hasNext() {
        // Doesn't basically have a limit
        return true;
    }

    @Override
    public Integer next() {
        int nextValue = previous + current;
        previous = current;
        current = nextValue;
        return previous;
    }
}
