package com.studentdataentry.model;

/**
 * Represents a Student entity with basic attributes: id, name, and age.
 * This class follows the JavaBean convention and acts as a POJO (Plain Old Java Object).
 */
public class Student {
    // Unique identifier for the student
    private int id;

    // Full name of the student
    private String name;

    // Age of the student
    private int age;

    /**
     * Constructor to initialize a Student object with id, name, and age.
     *
     * @param id    Unique student ID
     * @param name  Student's name
     * @param age   Student's age
     */
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Age
    public int getAge() {
        return age;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for Age
    public void setAge(int age) {
        this.age = age;
    }
}
