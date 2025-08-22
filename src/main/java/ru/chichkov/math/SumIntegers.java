package ru.chichkov.math;

// Задача 7.2.1
public class SumIntegers implements MathMethods {
    private final Integer number;

    public SumIntegers(Integer number) {
        this.number = number;
    }

    @Override
    public int sum() {
        return number.intValue();
    }
}
