package assignment3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner kbd = new Scanner(System.in)) {
            System.out.println("Please Enter the number of Students: ");
            int sNum = kbd.nextInt();

            Student[] arr = new Student[sNum];

            int i = 0;

            while (i < sNum) {
                System.out.println("Enter Student marks:" + (i + 1) + ":");
                System.out.print("ID : ");
                int student_ID = kbd.nextInt();
                System.out.print("Name : ");
                String name = kbd.next();
                
                double gpa = 0.0;
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("GPA : ");
                        gpa = kbd.nextDouble();
                        validInput = true;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Please check your input");
                        kbd.next();
                    }
                }

                arr[i] = new Student(student_ID, name, gpa);
                i++;
            }
        }
    }
}
