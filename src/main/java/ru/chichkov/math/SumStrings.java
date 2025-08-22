package ru.chichkov.math;

// Задача 7.2.1
public class SumStrings implements MathMethods {
    private final String string;

    public SumStrings(String string) {
        this.string = string;
    }

    @Override
    public int sum() {
        return string.length();
    }
}
