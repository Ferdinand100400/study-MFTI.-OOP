package ru.chichkov.geometry.points;

import lombok.Getter;

public class Point2D extends Point1D {
    @Getter
    private final int y;
    public Point2D(int x, int y) {
        super(x);
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + super.getX() + ";" + y + "}";
    }

}
