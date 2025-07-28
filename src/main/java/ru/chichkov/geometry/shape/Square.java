package ru.chichkov.geometry.shape;

// Задача 2.2.4
public class Square extends Rectangle {
    public Square(int length) {
        super(length, length);
    }

    @Override
    public void setLengthA(int lengthA) {
        super.setLength(lengthA, lengthA);
    }
    @Override
    public void setLengthB(int lengthB) {
        this.setLengthA(lengthB);
    }
    public void setLength(int length) {
        this.setLengthA(length);
    }
}
