// Name : Vedant Singh Thakur
// PRN : 23070126144
// Batch : AIML B3

package com.studentdataentry;

import com.studentdataentry.model.Student;
import com.studentdataentry.operations.StudentOperations;
import java.util.Scanner;

/**
 * Main class serves as the entry point of the Student Data Entry Application.
 * It provides a menu-driven interface to perform CRUD operations on student records.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Scanner to read user input
        StudentOperations ops = new StudentOperations(); // Object to perform operations
        int choice;

        // Menu loop
        do {
            System.out.println("\n--- Student Data Entry Menu ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Perform action based on user input
            switch (choice) {
                case 1 -> ops.insertStudent(); // Insert student record
                case 2 -> ops.displayStudents(); // Display all student records
                case 3 -> ops.updateStudent();   // Update existing student
                case 4 -> ops.deleteStudent(); // Delete student record
                case 5 -> System.out.println("Exiting...");   // Exit program
                default -> System.out.println("Invalid choice. Try again."); // Continue until user selects Exit
            }
        } while (choice != 5);

        sc.close(); // Close the scanner
    }
}
