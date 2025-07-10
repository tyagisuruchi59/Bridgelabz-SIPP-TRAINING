package ArrayPractice;

import java.util.Scanner;

public class StoreMultipleValuesInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double[] arr = new double[10]; // Array to store at most 10 positive values
        double var = 0.0;              // (Unused) variable — can be removed
        int idx = 0;                   // Index to insert values in the array
        double total = 0;             // Variable to keep track of the sum of valid inputs

        // Infinite loop to read input until stop condition is met
        while (true) {
            double input = s.nextDouble(); // Read user input

            // Stop reading if input is 0 or negative
            if (input <= 0) {
                break;
            }
            // Stop reading if array is full
            else if (idx == 10) {
                break;
            }
            // Otherwise, store the input in array and add to total
            else {
                arr[idx] = input;
                total += input;
                idx++;
            }
        }

        // Print the total of stored values
        System.out.println(total);
    }
}
