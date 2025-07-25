package ru.chichkov.math;

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

    public static int pow(String x, String y) {
        return (int) Math.pow(Integer.parseInt(x), Integer.parseInt(y));
    }
}
