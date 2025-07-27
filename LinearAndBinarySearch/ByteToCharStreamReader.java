package linearAndBinarySearch;

import java.io.*;

public class ByteToCharStreamReader {
    public static void main(String[] args) {
        String filePath = "utf8data.txt"; // The file should be in UTF-8 encoding

        try (
                FileInputStream fis = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader reader = new BufferedReader(isr)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line read
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding not supported: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
    }
}
