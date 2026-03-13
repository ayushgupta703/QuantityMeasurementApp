package com.bridgelabz.quantity_measurement_app.exception;

@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException {

    // Constructor with message
    public DatabaseException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}