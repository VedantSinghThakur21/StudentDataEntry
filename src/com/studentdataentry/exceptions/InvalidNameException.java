package com.studentdataentry.exceptions;

/**
 * Custom exception class to handle invalid name inputs.
 * This exception is thrown when the user enters a name that is null, empty, or contains invalid characters.
 * It extends RuntimeException, making it an unchecked exception.
 */
public class InvalidNameException extends RuntimeException {
    /**
     * Constructs a new InvalidNameException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidNameException(String message) {
        super(message);
    }
}
