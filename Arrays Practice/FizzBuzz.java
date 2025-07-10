package ArrayPractice;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner to take input

        int n = s.nextInt(); // Input a number

        // Create a String array of size = |n| (absolute value of n)
        String[] Array = new String[Math.abs(n)];

        int i = 0; // Index for filling the array

        // If number is positive, store its digits in reverse order in the array
        if(n > 0){
            while(n != 0){
                Array[i++] = String.valueOf(n % 10); // Store last digit as String
                n = n / 10; // Remove last digit
            }
        }
        // If number is divisible by 3 (and not positive), set array to "FIZZ"
        else if(n % 3 == 0){
            Array = new String[]{"F","I","Z","Z"};
        }
        // If number is divisible by 5 (and not positive), set array to "BUZZ"
        else if(n % 5 == 0){
            Array = new String[]{"B","U","Z","Z"};
        }
        // If number is neither divisible by 3 nor 5, set array to "FIZZBUZZ"
        else {
            Array = new String[]{"F","I","Z","Z","B","U","Z","Z"};
        }

        // Print the elements of the array
        for(int l = 0; l < Array.length; l++){
            if(Array[l] == null){
                continue; // Skip uninitialized positions
            }
            System.out.print(Array[l] + " ");
        }
    }
}
