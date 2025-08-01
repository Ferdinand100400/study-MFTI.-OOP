package ru.chichkov.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

// Задача 2.3.1
// Задача 4.2.2
public class MathMethods {

    public static double sum(Number... numbers) {
        double res = 0.0;
        for (Number num : numbers) {
            if (num == null) continue;
            res += num.doubleValue();
        }
        return res;
    }

    public static int myPow(String x, String y) {
        return (int) pow(parseInt(x), parseInt(y));
    }


    // Задача 4.2.2
    public static Double divNumbersFromString(String... str) {
        Double res = null;
        int i = 0;
        while (res == null && i < str.length) {
            try {
                res = Double.parseDouble(str[i]);
            } catch (NumberFormatException e) {
                i++;
            }
        }
        for (i += 1; i < str.length; i++) {
            try {
                res /= Double.parseDouble(str[i]);
            } catch (NumberFormatException e) {
            }
        }
        if (res == null) throw new IllegalArgumentException("Нет чисел в списке строк!");
        return res;
    }
}
