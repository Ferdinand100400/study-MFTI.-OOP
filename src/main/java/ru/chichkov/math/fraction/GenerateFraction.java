package ru.chichkov.math.fraction;


import ru.chichkov.math.fraction.Fraction;

import java.util.ArrayList;
import java.util.List;

// Задача 7.1.2
// Задача 7.1.3
// Задача 7.1.4
public class GenerateFraction {
    private static boolean onlyOneGenerateFraction = false;
    protected static List<Fraction> listFraction;

    public GenerateFraction() {
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
    protected static int findEqualsFractions(Fraction currentFraction) {
        for (int i = 0; i < listFraction.size(); i++) {
            if (currentFraction.equals(listFraction.get(i))) return i;
        }
        return -1;
    }
}
