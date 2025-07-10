package ArrayPractice;

import java.util.Scanner;

public class StudentVoteOrNot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Scanner to take input from user

        int[] Students = new int[10]; // Array to store age of 10 students

        // Read ages of 10 students
        for (int i = 0; i < Students.length; i++) {
            Students[i] = s.nextInt();
        }

        // Check if each student is eligible to vote
        for (int i = 0; i < Students.length; i++) {
            if (Students[i] >= 18) {
                System.out.println("The Student with the age " + Students[i] + " can vote.");
            } else {
                System.out.println("The Student with the age " + Students[i] + " cannot vote.");
            }
        }
    }
}
