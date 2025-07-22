package studyMFTI;

import lombok.Getter;

// Задача 1.5.5
// Задача 1.6.4
// Задача 2.1.1
// Задача 2.2.2
@Getter
public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator < 0) throw new IllegalArgumentException("Знаменатель не может быть отрицательным!");
        this.denominator = denominator;
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
}
