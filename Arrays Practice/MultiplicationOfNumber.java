package ArrayPractice;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplicationOfNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create Scanner to take input

        int n = s.nextInt(); // Input the number for which multiplication table is to be printed

        int[] multiply = new int[10]; // Array to store the multiplication table from 1 to 10

        // Loop from 1 to 10
        for(int i = 1; i <= 10; i++) {
            multiply[i - 1] = i * n; // Store the result of i * n in the array
        }

        // Print the complete multiplication table
        System.out.println(Arrays.toString(multiply));
    }
}
