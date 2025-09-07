package ru.chichkov.math.fraction;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Задача 1.5.5
// Задача 1.6.4
// Задача 2.1.1
// Задача 2.2.2
// Задача 5.1.1
// Задача 5.2.1
// Задача 7.1.4
@Getter
public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator < 0) throw new IllegalArgumentException("Знаменатель не может быть отрицательным!");
        this.denominator = denominator;
        if (GenerateFractionImpl.findEqualsFractions(this) == -1) GenerateFractionImpl.listFraction.add(this);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction fraction) {
        if (this.denominator == fraction.denominator)
            return new Fraction(this.numerator + fraction.numerator, this.denominator);
        int denominator = this.denominator * fraction.denominator;
        int numerator1 = this.numerator * fraction.denominator;
        int numerator2 = fraction.numerator * this.denominator;
        return new Fraction(numerator1 + numerator2, denominator);
    }

    public Fraction sum(int numbers) {
        return this.sum(new Fraction(numbers, 1));
    }

    public Fraction minus(Fraction fraction) {
        if (this.denominator == fraction.denominator)
            return new Fraction(this.numerator - fraction.numerator, this.denominator);
        int denominator = this.denominator * fraction.denominator;
        int numerator1 = this.numerator * fraction.denominator;
        int numerator2 = fraction.numerator * this.denominator;
        return new Fraction(numerator1 - numerator2, denominator);
    }

    public Fraction minus(int numbers) {
        return this.minus(new Fraction(numbers, 1));
    }

    public Fraction mul(Fraction fraction) {
        return new Fraction(numerator * fraction.numerator, denominator * fraction.denominator);
    }

    public Fraction mul(int number) {
        return this.mul(new Fraction(number, 1));
    }

    public Fraction div(Fraction fraction) {
        if (fraction.numerator < 0)
            return new Fraction(numerator * (-fraction.denominator), denominator * (-fraction.numerator));
        return new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
    }

    public Fraction div(int number) {
        return this.div(new Fraction(number, 1));
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction fraction)) return false;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    protected Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    // Задача 7.1.2
    // Задача 7.1.3
    // Задача 7.1.4
    public static class GenerateFractionImpl implements GenerateFraction {
        private static boolean onlyOneGenerateFraction = false;
        private static List<Fraction> listFraction;

        public GenerateFractionImpl() {
            if (onlyOneGenerateFraction) throw new IllegalArgumentException("Не может быть более одного генератора дробей");
            onlyOneGenerateFraction = true;
            listFraction = new ArrayList<>();
        }
        public Fraction generate(int numerator, int denominator) {
            Fraction fraction = new Fraction(numerator, denominator);
            if (findEqualsFractions(fraction) != -1) return listFraction.get(findEqualsFractions(fraction));
            listFraction.add(fraction);
            return fraction;
        }
        private static int findEqualsFractions(Fraction currentFraction) {
            for (int i = 0; i < listFraction.size(); i++) {
                if (currentFraction.equals(listFraction.get(i))) return i;
            }
            return -1;
        }
    }

}
