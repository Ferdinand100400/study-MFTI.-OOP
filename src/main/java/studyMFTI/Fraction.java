package studyMFTI;

// Задача 1.5.5
public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Деление на ноль!");
        this.numerator = numerator;
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
        if (fraction.numerator == 0) throw new IllegalArgumentException("Деление на ноль!");
        return new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
    }

    public Fraction div(int number) {
        return this.div(new Fraction(number, 1));
    }
}
