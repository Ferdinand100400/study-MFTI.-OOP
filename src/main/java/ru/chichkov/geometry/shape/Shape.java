package ru.chichkov.geometry.shape;

// Задача 2.2.4
public abstract class Shape {
    public void isPositive(int...length) {
        for (int len : length) {
            if (len < 0) throw new IllegalArgumentException("Длины сторон не могут быть меньше 0");
        }
    }
    public abstract double square();
}
