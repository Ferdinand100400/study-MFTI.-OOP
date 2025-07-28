package ru.chichkov.geometry.polyline;

import ru.chichkov.geometry.Line;
import ru.chichkov.geometry.point.Point;

// Задача 2.1.2
public class ClosedPolyline extends Polyline {
    public ClosedPolyline() {
        super();
    }

    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public int length() {
        if (getPoints().size() < 3) return super.length();
        return super.length() + (new Line(super.getPoints().get(0), super.getPoints().get(getPoints().size() - 1))).length();
    }
}
