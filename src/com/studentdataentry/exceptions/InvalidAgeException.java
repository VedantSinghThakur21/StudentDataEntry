package com.studentdataentry.exceptions;

/**
 * Custom exception class to handle invalid age inputs.
 * This exception is thrown when the user enters an age that is not within the valid range (e.g., less than 1 or greater than 150).
 * It extends RuntimeException, making it an unchecked exception.
 */
public class InvalidAgeException extends RuntimeException {
    /**
     * Constructs a new InvalidAgeException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
