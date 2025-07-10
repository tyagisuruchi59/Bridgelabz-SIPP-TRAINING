package ArrayPractice;

import java.util.Scanner;

public class LargestSecondLargestNumber2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Create Scanner to take input

        String Number = s.next(); // Take number input as a String (to handle digit-wise parsing)
        System.out.println();
        s.close(); // Close the scanner

        int[] Digits = new int[Number.length()]; // Create array to store each digit as an int

        // Convert each character to integer and store in array
        for(int i = 0; i < Number.length(); i++) {
            Digits[i] = (Number.charAt(i) - '0') % 10; // Convert char to digit
        }

        int largest = -1;        // Variable to track largest digit
        int secondlargest = -1;  // Variable to track second largest digit

        // First loop: Find the largest digit
        for(int i = 0; i < Digits.length; i++) {
            largest = Math.max(largest, Digits[i]);
        }

        // Second loop: Find second largest digit (which is less than largest)
        for(int i = 0; i < Digits.length; i++) {
            if(largest > Digits[i] && secondlargest < Digits[i]) {
                secondlargest = Digits[i];
            }
        }

        // Print the results
        System.out.print("The largest Number is : " + largest);
        System.out.println();
        System.out.print("The Secondlargest Number is : " + secondlargest);
    }
}
