package ArrayPractice;

import java.util.Scanner;

public class GradesSubjects {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int Students = s.nextInt();
            int marks[][] = new int[Students][3];
            double Percentage[] = new double[Students];
            String Grade[] = new String[Students];
            for(int i = 0;i<marks.length;i++){
                for (int j = 0; j < 3; j++) {
                    int input = s.nextInt();
                    if(input<0){
                        System.out.println("Enter Positive Value");
                        j--;
                    }
                    marks[i][j]  = input;
                }
            }

            for(int i = 0;i<marks.length;i++){
                int sum = 0;
                for(int j =0;j<3;j++){
                    sum+=marks[i][j];
                }
                double percentage = (double) (sum * 100) /300;
                Percentage[i] = percentage;
                if(percentage>=80){
                    Grade[i] = "A";
                }
                else  if(percentage>=70&&percentage<=79){
                    Grade[i] = "B";
                }
                else if(percentage>=60&&percentage<=69){
                    Grade[i] = "C";
                }
                else if(percentage>=50&&percentage<=59){
                    Grade[i] = "D";
                }
                else  if(percentage>=40&&percentage<=49){
                    Grade[i] = "E";
                }
                else{
                    Grade[i] = "R";
                }
            }
            for(int i = 0;i< marks.length;i++){
                for (int j = 0; j < 3; j++) {
                    System.out.println("The Marks of Student is " + marks[i][j]);
                }
                System.out.println("The Percentage is " + Percentage[i]);
                System.out.println("The Grade is " + Grade[i]);
            }

        }
    }

