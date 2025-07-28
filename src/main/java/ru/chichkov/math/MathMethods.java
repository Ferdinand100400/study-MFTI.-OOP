package ru.chichkov.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

// Задача 2.3.1
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
}
