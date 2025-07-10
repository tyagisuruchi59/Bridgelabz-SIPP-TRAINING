package ArrayPractice;

import java.util.Scanner;
import java.util.*; // For Arrays class

public class CopyInto1DArrayFrom2D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner to take input

        // Input number of rows and columns for the 2D matrix
        int rows = s.nextInt();
        int cols = s.nextInt();

        // Declare a 2D array (matrix) with given dimensions
        int [][] matrix = new int[rows][cols];

        // Fill the 2D array with user input
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length ; j++) {
                matrix[i][j] = s.nextInt(); // Take input for each element
            }
        }

        // Declare a 1D array with size equal to total elements in the 2D array
        int [] Array = new int[rows * cols];

        int p = 0; // Index for 1D array

        // Traverse the 2D matrix and copy elements into 1D array
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                Array[p++] = matrix[i][j]; // Assign element and increment pointer
            }
        }
        // Print the 1D array
        System.out.println(Arrays.toString(Array));
    }
}
