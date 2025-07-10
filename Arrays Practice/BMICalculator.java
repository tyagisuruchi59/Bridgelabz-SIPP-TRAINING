package Arraypractice;
import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of persons
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();

        // Arrays to store data
        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] BMI = new double[numberOfPersons];
        String[] status = new String[numberOfPersons];

        // Input data for each person
        for (int i = 0; i < numberOfPersons; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("\nPerson " + (i + 1) + " weight (kg): ");
                weights[i] = scanner.nextDouble();
                System.out.print("Person " + (i + 1) + " height (m): ");
                heights[i] = scanner.nextDouble();

                if (weights[i] <= 0 || heights[i] <= 0) {
                    System.out.println("Invalid input. Weight and height must be positive.");
                    i--; // Decrement index to re-enter data
                } else {
                    validInput = true;
                }
            }

            // Calculate BMI
            BMI[i] = weights[i] / (heights[i] * heights[i]);

            // Determine status
            if (BMI[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (BMI[i] <= 24.9) {
                status[i] = "Normal";
            } else if (BMI[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nBMI Results:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("Person %d: Height=%.2fm, Weight=%.2fkg, BMI=%.2f, Status=%s\n",
                    i + 1, heights[i], weights[i], BMI[i], status[i]);
        }
    }
}
