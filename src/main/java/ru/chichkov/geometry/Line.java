package ru.chichkov.geometry;


import lombok.Getter;
import ru.chichkov.geometry.point.Point;
import ru.chichkov.geometry.point.Point3D;

import java.util.Objects;

import static java.lang.Math.*;

// Задача 1.2.1
// Задача 1.4.2
// Задача 1.5.3
// Задача 1.6.6
// Задача 2.3.5
// Задача 5.1.3
// Задача 5.2.3
// Задача 6.1.5
@Getter
public class Line<T extends Point> implements InterfaceLength {
    private T startPoint;
    private T endPoint;
    private final Class<T> typePoint;

    private static <T extends Point> T createPoint(T point, Class<T> typePoint) {
        if (!point.getClass().equals(typePoint))
            throw new IllegalArgumentException("Тип точки и тип передаваемой точки не совпадают");
        if (typePoint.equals(Point.class)) return (T) new Point(point.getX(), point.getY());
        return (T) new Point3D(point.getX(), point.getY(), ((Point3D) point).getZ());
    }

    public Line(T point1, T point2, Class<T> typePoint) {
        startPoint = createPoint(point1, typePoint);
        endPoint = createPoint(point2, typePoint);
        this.typePoint = typePoint;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this((T) new Point(x1, y1), (T) new Point(x2, y2), (Class<T>) Point.class);
    }

    public Line(int x1, int y1, int z1, int x2, int y2, int z2) {
        this((T) new Point3D(x1, y1, z1), (T) new Point3D(x2, y2, z2), (Class<T>) Point3D.class);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }

    public void setStartPoint(T startPoint) {
        this.startPoint = createPoint(startPoint, typePoint);
    }

    public void setEndPoint(T endPoint) {
        this.endPoint = createPoint(endPoint, typePoint);
    }

    @Override
    public int length() {
        if (this.typePoint.equals(Point.class))
            return (int) abs(sqrt(pow(startPoint.getX() - endPoint.getX(), 2) + pow(startPoint.getY() - endPoint.getY(), 2)));
        Point3D startPoint = (Point3D) this.startPoint;
        Point3D endPoint = (Point3D) this.endPoint;
        return (int) abs(sqrt(pow(startPoint.getX() - endPoint.getX(), 2) + pow(startPoint.getY() - endPoint.getY(), 2) + pow(startPoint.getZ() - endPoint.getZ(), 2)));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Line line)) return false;
        return (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint))
                || (startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.length(), startPoint.getX() + endPoint.getX(), startPoint.getY() + endPoint.getY());
    }

    @Override
    public Line<? extends Point> clone() throws CloneNotSupportedException {
        return new Line<T>(this.startPoint, this.endPoint, this.typePoint);
    }
}
