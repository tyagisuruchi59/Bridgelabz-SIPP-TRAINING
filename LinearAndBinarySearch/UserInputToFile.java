package linearAndBinarySearch;


import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String outputFilePath = "user_input.txt";

        try (
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(isr);
                FileWriter writer = new FileWriter(outputFilePath)
        ) {
            String inputLine;
            System.out.println("Enter text (type 'exit' to finish):");

            while (!(inputLine = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(inputLine + System.lineSeparator());
            }

            System.out.println("Input saved to file: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
