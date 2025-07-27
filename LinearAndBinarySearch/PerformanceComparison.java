package linearAndBinarySearch;

import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) throws Exception {
        int iterations = 1_000_000;
        String sample = "hello";

        // Measure StringBuilder
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder time: " + (endSB - startSB) / 1_000_000 + " ms");

        // Measure StringBuffer
        long startSBuf = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append(sample);
        }
        long endSBuf = System.nanoTime();
        System.out.println("StringBuffer time: " + (endSBuf - startSBuf) / 1_000_000 + " ms");

        // File Reading - FileReader
        String filePath = "largefile.txt"; // Assume this file is 100MB

        long startFR = System.nanoTime();
        int frWordCount = countWordsUsingFileReader(filePath);
        long endFR = System.nanoTime();
        System.out.println("FileReader word count: " + frWordCount);
        System.out.println("FileReader time: " + (endFR - startFR) / 1_000_000 + " ms");

        // File Reading - InputStreamReader
        long startISR = System.nanoTime();
        int isrWordCount = countWordsUsingInputStreamReader(filePath);
        long endISR = System.nanoTime();
        System.out.println("InputStreamReader word count: " + isrWordCount);
        System.out.println("InputStreamReader time: " + (endISR - startISR) / 1_000_000 + " ms");
    }

    public static int countWordsUsingFileReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.trim().split("\\s+").length;
            }
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        int wordCount = 0;
        try (
                FileInputStream fis = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.trim().split("\\s+").length;
            }
        }
        return wordCount;
    }
}
