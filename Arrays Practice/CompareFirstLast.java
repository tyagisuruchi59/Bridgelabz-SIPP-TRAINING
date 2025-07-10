package ArrayPractice;

import java.util.Scanner;

public class CompareFirstLast {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner object to take input from user

        int n = 5; // Size of the array is fixed to 5
        int[] arr = new int[n]; // Declare and initialize the array of size 5

        // Input loop to fill the array with user values
        for(int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt(); // Take input from user at each index

            // Check if the number is positive
            if(arr[i] > 0){
                // If positive, check if even or odd
                if(arr[i] % 2 == 0){
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            }

            // If number is negative
            else if(arr[i] < 0){
                System.out.println("Negative");
            }

            // If number is zero
            else if(arr[i] == 0){
                System.out.println("Zero");
            }
        }

        // Compare the first and last element of the array
        if(arr[0] > arr[arr.length - 1]){
            System.out.println("1stElement is Greater");
        }
        else if(arr[arr.length - 1] > arr[0]){
            System.out.println("LastElement is Greater");
        }
        else {
            System.out.println("Both Are Equal");
        }
    }
}
