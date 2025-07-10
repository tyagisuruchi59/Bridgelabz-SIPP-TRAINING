package ArrayPractice;

import java.util.Scanner;

public class BonusOfEmployees {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Arrays to store salary, years of service, new salaries, and bonus amounts
        double Salary[] = new double[10];
        double YearOfService[] = new double[10];
        double NewSalary[] = new double[10];
        double BonusAmount[] = new double[10];

        // Variables to store total values
        double TotalNewSalary = 0.0;
        double OldSalary = 0.0;
        double Bonus = 0.0;

        // Input salaries of 10 employees
        for (int i = 0; i < Salary.length; i++) {
            double salary = s.nextDouble();
            Salary[i] = salary;

            // Validate salary input
            if (salary < 1) {
                System.out.println("Invalid Salary Enter Correctly");
                i--; // Re-enter value for this index
            }
        }

        // Input years of service of 10 employees
        for (int i = 0; i < YearOfService.length; i++) {
            double yearofservice = s.nextDouble();
            YearOfService[i] = yearofservice;

            // Validate service years input
            if (yearofservice < 1) {
                i--; // Re-enter value for this index
            }
        }

        // Calculate bonus and new salary based on years of service
        for (int i = 0; i < YearOfService.length; i++) {
            if (YearOfService[i] > 5) {
                // Bonus of 5% for more than 5 years
                BonusAmount[i] = 0.05 * Salary[i];
                NewSalary[i] = Salary[i] + BonusAmount[i];
            } else {
                // Bonus of 2% for 5 or fewer years
                BonusAmount[i] = 0.02 * Salary[i];
                NewSalary[i] = Salary[i] + BonusAmount[i];
            }
        }

        // Calculate totals
        double TotalBonus = 0.0;
        double TotalOldSalary = 0.0;
        double NewSalaryTotal = 0.0;

        for (int i = 0; i < BonusAmount.length; i++) {
            TotalBonus += BonusAmount[i];
        }

        for (int i = 0; i < Salary.length; i++) {
            TotalOldSalary += Salary[i];
        }

        for (int i = 0; i < NewSalary.length; i++) {
            NewSalaryTotal += NewSalary[i];
        }

        // Display total results
        System.out.println("Total Old Salary " + TotalOldSalary);
        System.out.println("Total New Salary " + NewSalaryTotal);
        System.out.println("Total Bonuses " + TotalBonus);
    }
}
