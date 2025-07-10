package ArrayPractice;

import java.util.*;

public class MeanHeightOfPlayer {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in); // Scanner to read input

        double Heights[] = new double[10]; // Array to store heights of 11 players

        // Input loop: Read height for each player
        for(int i = 0; i < 10; i++){ // ❗ Fixed loop condition (was i <= 11, which causes ArrayIndexOutOfBounds)
            Heights[i] = s.nextDouble(); // Read and store each height
        }

        double sum = 0; // To calculate the total sum of heights

        // Sum all heights
        for(int i = 0; i < Heights.length; i++) {
            sum += Heights[i];
        }

        double average = sum / 11; // Calculate mean (average) height

        System.out.println(average); // Print the average height
    }
}
