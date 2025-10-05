package ru.chichkov.tests;

public class TestFailedException extends RuntimeException {
    Object expected, actual;
    public TestFailedException() {
    }

    public TestFailedException(String message) {
        super(message);
    }

    public TestFailedException(Object expected, Object actual) {
        super("Результат " + expected + " но должно быть " + actual);
        this.expected = expected;
        this.actual = actual;
    }
}
