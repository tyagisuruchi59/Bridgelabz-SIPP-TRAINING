package linearAndBinarySearch;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        // Specify the path to your file
        String filePath = "sample.txt";

        // Call the method to read and print file content
        readFile(filePath);
    }

    public static void readFile(String fileName) {
        BufferedReader reader = null;

        try {
            // Create FileReader and wrap it in BufferedReader
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            String line;

            // Read and print each line until end of file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        } finally {
            // Always close the BufferedReader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing the file reader:");
                ex.printStackTrace();
            }
        }
    }
}
