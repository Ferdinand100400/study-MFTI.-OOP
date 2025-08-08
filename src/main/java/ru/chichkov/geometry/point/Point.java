package ru.chichkov.geometry.point;

import lombok.Data;

import java.util.Objects;

// Задача 1.1.1
// Задача 1.4.1
// Задача 5.1.2
@Data
public sealed class Point permits Point3D {
    private final int x;
    private final int y;


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
}

