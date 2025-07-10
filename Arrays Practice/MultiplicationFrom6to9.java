package ArrayPractice;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplicationFrom6to9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner created (though not used in this code)

        int n = 4;         // We want to print tables from 6 to 9 => 4 tables
        int start = 6;     // Start from multiplication table of 6

        // Loop runs 4 times to print tables of 6, 7, 8, and 9
        while(n-- > 0) {
            int[] arr = new int[11]; // Array to store the multiplication table (from 1*start to 10*start)
            int p = 0;               // Pointer to fill array

            // Generate table from 1 to 10
            for(int i = 1; i <= 10; i++) {
                arr[p++] = i * start; // Multiply and store in array
            }

            // Print the full table
            System.out.println(Arrays.toString(arr));

            start++; // Move to the next number for table (e.g., 6 → 7 → 8 → 9)
        }
    }
}
