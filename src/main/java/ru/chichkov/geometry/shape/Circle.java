package ru.chichkov.geometry.shape;

import lombok.Getter;

// Задача 2.2.4
@Getter
public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.setRadius(radius);
    }

    public void setRadius(int radius) {
        isPositive(radius);
        this.radius = radius;
    }

    @Override
    public double square() {
        return Math.PI * radius * radius;
    }
}
