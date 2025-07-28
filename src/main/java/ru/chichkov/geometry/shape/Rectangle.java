package ru.chichkov.geometry.shape;

import lombok.Getter;

// Задача 2.2.4
@Getter
public class Rectangle extends Shape {
    private int lengthA;
    private int lengthB;

    public Rectangle(int lengthA, int lengthB) {
        this.setLength(lengthA, lengthB);
    }

    public void setLength(int lengthA, int lengthB) {
        isPositive(lengthA, lengthB);
        this.lengthA = lengthA;
        this.lengthB = lengthB;
    }
    public void setLengthA(int lengthA) {
        this.setLength(lengthA, this.lengthB);
    }

    public void setLengthB(int lengthB) {
        this.setLength(this.lengthA, lengthB);
    }

    @Override
    public double square() {
        return lengthA * lengthB;
    }
}
