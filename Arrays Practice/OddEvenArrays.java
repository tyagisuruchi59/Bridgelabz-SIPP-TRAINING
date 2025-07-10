package ArrayPractice;

import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner to take input from user

        int n = s.nextInt(); // Input: upper limit number
        if(n < 1) {
            System.out.println("error"); // Guard clause for invalid input
        }

        // Arrays to store even and odd numbers separately
        int[] Even = new int[(n / 2) + 1]; // Allocate extra 1 to handle edge cases
        int[] Odd = new int[(n / 2) + 1];

        if(n >= 1) {
            int eidx = 0;  // Index pointer for Even array
            int oidx = 0;  // Index pointer for Odd array

            // Fill arrays with even and odd numbers from 1 to n
            for(int i = 1; i <= n; i++) {
                if(i % 2 == 0) {
                    Even[eidx++] = i;
                } else {
                    Odd[oidx++] = i;
                }
            }
        }

        // Print all even numbers
        System.out.println("The Even Numbers");
        for(int l : Even) {
            if(l == 0) continue; // Skip 0s (leftovers in array)
            else System.out.print(l + " ");
        }

        System.out.println(); // Newline

        // Print all odd numbers
        System.out.println("The Odd Numbers");
        for(int k : Odd) {
            if(k == 0) continue; // Skip 0s
            else System.out.print(k + " ");
        }
    }
}
