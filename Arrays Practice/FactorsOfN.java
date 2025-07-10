package ArrayPractice;

import java.util.Arrays;
import java.util.Scanner;

public class FactorsOfN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner for input

        int n = s.nextInt(); // Input number to find its factors
        int index = 0; // Index to track position in Factors array
        int MaxFactor = 10; // Initial size of Factors array

        // Array to store the factors (dynamically resizable)
        int[] Factors = new int[MaxFactor];

        // Loop through all numbers from 1 to n to check for factors
        for(int i = 1; i <= n; i++) {
            // If array is full, double its size
            if(index >= MaxFactor){
                MaxFactor = MaxFactor * 2;
                Factors = Arrays.copyOf(Factors, MaxFactor); // Resize array
            }

            // If i divides n completely, it is a factor
            if(n % i == 0){
                Factors[index] = i; // Store factor in array
                index++; // Move to next index
            }
        }

        // Print the factors (ignoring any trailing 0s from unused array space)
        for (int factor : Factors) {
            if(factor == 0){
                continue; // Skip 0s (unfilled elements)
            }
            System.out.print(factor + " ");
        }
    }
}
