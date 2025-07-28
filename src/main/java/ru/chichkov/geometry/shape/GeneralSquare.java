package ru.chichkov.geometry.shape;

// Задача 2.3.3
public class GeneralSquare {

    // Задача 2.3.3
    public static double generalSquare(Shape... shapes) {
        double res = 0;
        for (Shape shape: shapes) {
            res += shape.square();
        }
        return res;
    }
}
