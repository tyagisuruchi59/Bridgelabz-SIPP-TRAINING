package linearAndBinarySearch;

public class StringConcatPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million
        String word = "hello";

        // Measure time for StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(word);
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // Measure time for StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbd.append(word);
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // Print results
        System.out.println("Time taken using StringBuffer: " + bufferTime / 1_000_000 + " ms");
        System.out.println("Time taken using StringBuilder: " + builderTime / 1_000_000 + " ms");

        // Optional: show which one is faster
        if (bufferTime > builderTime) {
            System.out.println("StringBuilder is faster.");
        } else if (bufferTime < builderTime) {
            System.out.println("StringBuffer is faster.");
        } else {
            System.out.println("Both performed equally.");
        }
    }
}

