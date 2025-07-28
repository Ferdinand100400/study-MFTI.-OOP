package ru.chichkov.geometry;

import ru.chichkov.geometry.polyline.ClosedPolyline;
import ru.chichkov.geometry.point.Point;

// Задача 1.5.8
// Задача 1.6.3
// Задача 2.3.6
// Задача 2.3.7
public class Square implements InterfacePolyline {
    private final Point leftTopPoint;
    private int lengthSide;

    public Square(Point pointLeftTop, int lengthSide) {
        this.leftTopPoint = pointLeftTop;
        this.setLengthSide(lengthSide);
    }

    public Square(int x, int y, int lengthSide) {
        this(new Point(x, y), lengthSide);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + leftTopPoint + " со стороной " + lengthSide;
    }

    public int getLengthSide() {
        return lengthSide;
    }

    public void setLengthSide(int lengthSide) {
        if (lengthSide < 1) throw new IllegalArgumentException("Длина стороны не может быть меньше 1");
        this.lengthSide = lengthSide;
    }

    @Override
    public ClosedPolyline getPolyline() {
        int xRight = leftTopPoint.getX() + lengthSide;
        int yDown = leftTopPoint.getY() - lengthSide;
        return new ClosedPolyline(leftTopPoint, new Point(xRight, leftTopPoint.getY()),
                new Point(xRight, yDown), new Point(leftTopPoint.getX(), yDown), leftTopPoint);
    }
}
