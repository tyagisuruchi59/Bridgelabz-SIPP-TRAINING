package ArrayPractice;

import java.util.Scanner;

public class GradesOfSubjects {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Input number of students
        int Students = s.nextInt();

        // 2D array to store marks for 3 subjects per student
        int marks[][] = new int[Students][3];

        // Arrays to store percentage and grade
        double[] Percentage = new double[Students];
        String[] Grade = new String[Students];

        // Input marks for each student
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < 3; j++) {
                int input = s.nextInt();

                // Validate mark (must be non-negative and reasonable, e.g., <=100)
                if (input < 0 || input > 100) {
                    System.out.println("Enter a valid mark between 0 and 100.");
                    j--; // retry same subject
                    continue;
                }

                marks[i][j] = input;
            }
        }

        // Calculate percentage and assign grade
        for (int i = 0; i < Students; i++) {
            int sum = 0;

            // Sum marks of 3 subjects
            for (int j = 0; j < 3; j++) {
                sum += marks[i][j];
            }

            // Calculate percentage
            double percentage = (double) sum * 100 / 300;
            Percentage[i] = percentage;

            // Assign grade based on percentage
            if (percentage >= 80) {
                Grade[i] = "A";
            } else if (percentage >= 70) {
                Grade[i] = "B";
            } else if (percentage >= 60) {
                Grade[i] = "C";
            } else if (percentage >= 50) {
                Grade[i] = "D";
            } else if (percentage >= 40) {
                Grade[i] = "E";
            } else {
                Grade[i] = "R"; // R for Reappear
            }
        }

        // Display results
        for (int i = 0; i < Students; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            for (int j = 0; j < 3; j++) {
                System.out.println("Subject " + (j + 1) + " Marks: " + marks[i][j]);
            }
            System.out.printf("Percentage: %.2f%%\n", Percentage[i]);
            System.out.println("Grade: " + Grade[i]);
        }

        s.close();
    }
}
