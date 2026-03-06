import java.util.Random;

public class MainStrategy {

    public static long measure(Runnable r) {
        long start = System.nanoTime();
        r.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {

        // Data
        Random rnd = new Random();
        int[] small = new int[30];
        int[] large = new int[100000];

        for (int i = 0; i < small.length; i++)
            small[i] = rnd.nextInt(100);

        for (int i = 0; i < large.length; i++)
            large[i] = rnd.nextInt(1000000);

        BubbleSort bs = new BubbleSort();
        InsertionSort is = new InsertionSort();
        QuickSort qs = new QuickSort();


        // SMALL DATASET
        System.out.println("SMALL (30 elements)");

        long bubbleSmall = measure(() -> {
            int[] copy = small.clone();
            bs.bubbleSort(copy, copy.length);
        });

        long insertionSmall = measure(() -> {
            int[] copy = small.clone();
            is.sort(copy);
        });

        long quickSmall = measure(() -> {
            int[] copy = small.clone();
            qs.quickSort(copy, 0, copy.length - 1);
        });

        System.out.println("Bubble:    " + bubbleSmall / 1_000_000.0 + " ms");
        System.out.println("Insertion: " + insertionSmall / 1_000_000.0 + " ms");
        System.out.println("Quick:     " + quickSmall / 1_000_000.0 + " ms");


        // LARGE DATASET
        System.out.println();
        System.out.println("LARGE (100000 elements)");

        long bubbleLarge = measure(() -> {
            int[] copy = large.clone();
            bs.bubbleSort(copy, copy.length);
        });

        long insertionLarge = measure(() -> {
            int[] copy = large.clone();
            is.sort(copy);
        });

        long quickLarge = measure(() -> {
            int[] copy = large.clone();
            qs.quickSort(copy, 0, copy.length - 1);
        });


        System.out.println("Bubble: " + bubbleLarge / 1_000_000.0 + " ms");
        System.out.println("Insertion: " + insertionLarge / 1_000_000.0 + " ms");
        System.out.println("Quick:     " + quickLarge / 1_000_000.0 + " ms");
    }
}