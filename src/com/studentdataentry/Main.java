package com.studentdataentry;

import com.studentdataentry.model.Student;
import com.studentdataentry.operations.StudentOperations;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentOperations ops = new StudentOperations();
        int choice;

        do {
            System.out.println("\n--- Student Data Entry Menu ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> ops.insertStudent();
                case 2 -> ops.displayStudents();
                case 3 -> ops.updateStudent();
                case 4 -> ops.deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
