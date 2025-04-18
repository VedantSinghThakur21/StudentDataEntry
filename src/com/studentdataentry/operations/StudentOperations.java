package com.studentdataentry.operations;

import com.studentdataentry.database.DatabaseConnector;
import com.studentdataentry.exceptions.InvalidAgeException;
import com.studentdataentry.exceptions.InvalidNameException;
import com.studentdataentry.model.Student;

import java.sql.*;
import java.util.Scanner;

/**
 * StudentOperations class provides core functionality for CRUD operations
 * (Create, Read, Update, Delete) on Student records in the database.
 */
public class StudentOperations {
    private final Scanner sc = new Scanner(System.in);// Scanner for user input

    /**
     * Inserts a new student record into the database after validating input.
     */
    public void insertStudent() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            validateName(name); // Validate name before insertion

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            validateAge(age); // Validate age before insertion

            // Prepare SQL insert statement
            String query = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();

            System.out.println("Student inserted successfully.");
        } catch (SQLException | InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays all student records from the database.
     */
    public void displayStudents() {
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d\n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Updates an existing student's name and age in the database.
     */
    public void updateStudent() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            validateName(name);

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            validateAge(age);

            String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) System.out.println("Student updated successfully.");
            else System.out.println("Student ID not found.");
        } catch (SQLException | InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Deletes a student record based on the given ID.
     */
    public void deleteStudent() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) System.out.println("Student deleted successfully.");
            else System.out.println("Student ID not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Validates the student's name.
     *
     * @param name Name to validate
     * @throws InvalidNameException if name is null or contains non-alphabetic characters
     */
    private void validateName(String name) throws InvalidNameException {
        if (name == null || !name.matches("[A-Za-z ]+")) {
            throw new InvalidNameException("Name must contain only letters and spaces.");
        }
    }

    /**
     * Validates the student's age.
     *
     * @param age Age to validate
     * @throws InvalidAgeException if age is not within a realistic range
     */
    private void validateAge(int age) throws InvalidAgeException {
        if (age <= 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 1 and 150.");
        }
    }
}