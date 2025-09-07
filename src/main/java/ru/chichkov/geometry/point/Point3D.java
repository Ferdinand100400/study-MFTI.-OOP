package ru.chichkov.geometry.point;

import lombok.Getter;

import java.util.Objects;

// Задача 2.1.5
// Задача 5.1.2
// Задача 7.1.2
public final class Point3D extends Point {
    @Getter
    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public static Point3D of(int x, int y, int z) {
        return new Point3D(x, y, z);
    }
    @Override
    public String toString() {
        return "{" + super.getX() + ";" + super.getY() + ";" + z + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D point3D)) return false;
        return super.equals(point3D) && z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}
