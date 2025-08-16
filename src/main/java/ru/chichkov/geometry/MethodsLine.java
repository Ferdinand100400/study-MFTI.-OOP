package ru.chichkov.geometry;

import ru.chichkov.geometry.point.Point;
import ru.chichkov.geometry.point.Point3D;

// Задача 6.2.1
public class MethodsLine {
    public static <T extends Point> void moveLineToXBy10(Line<T> line) {
        int x = line.getStartPoint().getX();
        int y = line.getStartPoint().getY();
        try {
            if (line.getTypePoint().equals(Point.class)) {
                T newStartPoint = (T) new Point(x + 10, y);
                line.setStartPoint(newStartPoint);
            }
            if (line.getTypePoint().equals(Point3D.class)) {
                Point3D point3D = (Point3D) line.getStartPoint();
                int z = point3D.getZ();
                T newStartPoint = (T) new Point3D(x + 10, y, z);
                line.setStartPoint(newStartPoint);
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Ошибка создания экземпляра точки");
        }
    }
}
