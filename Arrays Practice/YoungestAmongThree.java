package ArrayPractice;

import java.util.Scanner;

public class YoungestAmongThree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] Ages = new int[3];     // Array to store ages of 3 people
        int[] Heights = new int[3];  // Array to store heights of 3 people

        // Input ages
        System.out.println("Enter ages of 3 people:");
        for (int i = 0; i < Ages.length; i++) {
            Ages[i] = s.nextInt();
        }

        // Input heights
        System.out.println("Enter heights of the same 3 people:");
        for (int i = 0; i < Heights.length; i++) {
            Heights[i] = s.nextInt();
        }

        // Initialize with extremes
        int youngest = Integer.MAX_VALUE; // Set to highest possible to find minimum
        int tallest = 0;                  // Set to 0 to find maximum

        // Traverse arrays to find youngest and tallest
        for (int i = 0; i < Heights.length; i++) {
            tallest = Math.max(tallest, Heights[i]);
            youngest = Math.min(youngest, Ages[i]);
        }

        // Output results
        System.out.println("The Tallest One : " + tallest);
        System.out.println("The Youngest One : " + youngest);
    }
}
