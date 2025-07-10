package ArrayPractice;

import java.util.Scanner;

public class LargestSecondLargestNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create Scanner to take input from user

        int Number = s.nextInt(); // Input a number whose digits we will analyze

        int MaxDigit = 10; // Maximum number of digits we assume the number can have
        int[] digits = new int[MaxDigit + 1]; // Array to store each digit of the number
        int index = 0; // Keeps track of how many digits we store

        // Extract each digit from the number and store it into the array
        while (Number != 0) {
            digits[index] = Number % 10; // Store the last digit of the number
            Number = Number / 10;        // Remove the last digit from the number
            index++;                     // Move to the next index in array

            // Avoid overflow if number has more than MaxDigit digits
            if (index >= MaxDigit) {
                break;
            }
        }

        int largest = Integer.MIN_VALUE;        // Variable to store the largest digit
        int secondlargest = Integer.MIN_VALUE;  // Variable to store the second largest digit

        // First loop: Find the largest digit in the array
        for (int i = 0; i < digits.length; i++) {
            largest = Math.max(largest, digits[i]);
        }

        // Second loop: Find the second largest digit (less than largest)
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != largest && digits[i] > secondlargest) {
                secondlargest = digits[i];
            }
        }

        // Print the largest digit
        System.out.print("Largest " + largest);
        System.out.println();

        // Print the second largest digit
        System.out.print("Secondlargest " + secondlargest);
    }
}
