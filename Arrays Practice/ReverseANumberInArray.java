package ArrayPractice;

import java.util.Scanner;

public class ReverseANumberInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner to read user input

        int Number = s.nextInt(); // Input the number to be reversed
        int CountDigit = 0;       // Variable to count number of digits

        int TempNum = Number;     // Create a copy of the number to count digits without changing original
        while(TempNum != 0) {     // Loop until all digits are processed
            TempNum = TempNum / 10; // Remove last digit
            CountDigit++;          // Count digit
        }

        int idx = 0; // Index to insert digits in array
        int[] Digits = new int[CountDigit]; // Array to store digits in reverse order

        // Extract digits from right to left and store in array
        while(Number != 0) {
            Digits[idx++] = Number % 10; // Get last digit
            Number = Number / 10;        // Remove last digit
        }

        // Print the reversed number stored in array
        for(int i = 0; i < Digits.length; i++) {
            System.out.print(Digits[i]);
        }
    }
}
