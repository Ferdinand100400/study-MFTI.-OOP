package ru.chichkov.exception;

// Задача 4.1.2
public class LossOfConnectionException extends Exception {
    public LossOfConnectionException() {
    }

    public LossOfConnectionException(String message) {
        super(message);
    }

    public LossOfConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public LossOfConnectionException(Throwable cause) {
        super(cause);
    }
}
