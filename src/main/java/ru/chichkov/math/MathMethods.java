package ru.chichkov.math;

import ru.chichkov.geometry.Line;

import java.util.List;
import java.util.Random;

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

    // Задача 6.2.4
    public static <T extends Number> void fillingNumbers(List<T> list) {
        Random random = new Random();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Integer number = random.nextInt(100) + 1;
            list.set(i, (T) number);
        }
    }

    // Задача 6.3.1
    public static <T extends Number> T max(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].doubleValue() > max.doubleValue()) max = array[i];
        }
        return max;
    }

    // Задача 6.3.2
    public static <T extends Number> boolean negativeArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].doubleValue() > 0) return false;
        }
        return true;
    }
}
