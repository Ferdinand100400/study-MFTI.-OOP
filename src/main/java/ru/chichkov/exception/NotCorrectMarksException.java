package ru.chichkov.exception;

// Задача 4.1.1
public class NotCorrectMarksException extends RuntimeException {
    public NotCorrectMarksException() {
    }
    public NotCorrectMarksException(String message) {
        super(message);
    }
}
