package ArrayPractice;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyOfDigit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create Scanner for user input

        int n = s.nextInt(); // Read the number from user

        int[] digits = new int[10]; // Array to store frequency of digits 0–9

        // Loop through each digit of the number
        while(n != 0){
            digits[n % 10]++; // Increment count at index equal to the current digit
            n = n / 10;       // Remove the last digit from the number
        }

        // Print frequency array
        System.out.println(Arrays.toString(digits));
    }
}
