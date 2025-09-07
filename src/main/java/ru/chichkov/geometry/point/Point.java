package ru.chichkov.geometry.point;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

// Задача 1.1.1
// Задача 1.4.1
// Задача 5.1.2
// Задача 5.2.2
// Задача 7.1.2
@Getter
public sealed class Point permits Point3D {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }
    public static Point of(int x, int y, int z) {
        return Point3D.of(x, y, z);
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    protected Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }
}

