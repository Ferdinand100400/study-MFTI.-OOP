package ru.chichkov.geometry.Shape;

import lombok.Getter;

import static java.lang.Math.sqrt;

// Задача 2.2.4
@Getter
public class Triangle extends Shape {
    private int lengthA;
    private int lengthB;
    private int lengthC;

    public Triangle(int lengthA, int lengthB, int lengthC) {
        this.setLength(lengthA, lengthB, lengthC);
    }

    public void setLength(int lengthA, int lengthB, int lengthC) {
        isPositive(lengthA, lengthB, lengthC);
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
        isTriangle();
    }
    public void setLengthA(int lengthA) {
        this.setLength(lengthA, this.lengthB, this.lengthC);
    }

    public void setLengthB(int lengthB) {
        this.setLength(this.lengthA, lengthB, this.lengthC);
    }

    public void setLengthC(int lengthC) {
        this.setLength(this.lengthA, this.lengthB, lengthC);
    }

    @Override
    public double square() {
        int p = lengthA + lengthB + lengthC;
        return sqrt(p * (p - lengthA) * (p - lengthB) * (p - lengthC));
    }

    private void isTriangle() {
        if (!((lengthA + lengthB > lengthC) && (lengthB + lengthC > lengthA) && (lengthC + lengthA > lengthB)))
            throw new IllegalArgumentException("Невозможно составить треугольник с данными сторанами");
    }
}
