package linearAndBinarySearch;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Path to the text file
        String targetWord = "java";     // Word to count (case-insensitive)

        int count = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appeared " + count + " times.");
    }

    public static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;
        BufferedReader reader = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words using space and punctuation as delimiters
                String[] words = line.split("\\W+"); // \W+ matches non-word characters

                for (String word : words) {
                    // Compare ignoring case
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        } finally {
            // Close the reader
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                System.out.println("Error closing the reader.");
                e.printStackTrace();
            }
        }

        return count;
    }
}
