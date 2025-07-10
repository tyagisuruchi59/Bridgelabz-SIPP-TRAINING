package ArrayPractice;

import java.util.Scanner;

public class BMIofTeamMembers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Take input for number of persons
        int Persons = s.nextInt();

        // Arrays to store weight (int), height (double), BMI (double), and weight status (String)
        int[] Weight = new int[Persons];
        double[] Height = new double[Persons];
        double[] BMI = new double[Persons];
        String[] WeightStatus = new String[Persons];

        // Input weight and height for each person
        for (int i = 0; i < Weight.length; i++) {
            Weight[i] = s.nextInt();         // Take weight in kg (no validation here)
            Height[i] = s.nextDouble();      // Take height in meters (no validation here)
        }

        // Calculate BMI and determine weight status for each person
        for (int i = 0; i < BMI.length; i++) {
            // BMI formula: BMI = weight / (height)^2
            BMI[i] = Weight[i] / Math.pow(Height[i], 2);

            // Classify based on BMI ranges
            if (BMI[i] <= 18.4) {
                WeightStatus[i] = "UnderWeight";
            } else if (BMI[i] <= 24.9) {
                WeightStatus[i] = "Normal";
            } else if (BMI[i] <= 39.9) {
                WeightStatus[i] = "OverWeight";
            } else {
                WeightStatus[i] = "Obese";
            }
        }

        // Print height, weight, BMI, and weight status for each person
        for (int i = 0; i < Weight.length; i++) {
            System.out.println("Weight of The Person is");
            System.out.println(Weight[i]);

            System.out.println("Height of The Person is");
            System.out.println(Height[i]);

            System.out.println("BMI of The Person is");
            System.out.println(BMI[i]);

            System.out.println("Weight Status of The Person is");
            System.out.println(WeightStatus[i]);
        }

        s.close();
    }
}
