package ru.chichkov.geometry.polyline;

import ru.chichkov.geometry.Line;
import ru.chichkov.geometry.point.Point;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

// Задача 2.1.2
// Задача 5.1.4
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
        return super.length() + (new Line(super.getPoints().get(0), super.getPoints().get(getPoints().size() - 1), Point.class)).length();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass().getName().equals("ru.chichkov.geometry.polyline.Polyline")) return o.equals(this);
        if (!(o instanceof ClosedPolyline closedPolyline)) return false;
        if (this.getPoints().size() != closedPolyline.getPoints().size()) return false;
        for (int i = 0; i < closedPolyline.getPoints().size(); i++) {
            if (!this.getPoints().get(i).equals(closedPolyline.getPoints().get(i))) break;
            if (i == closedPolyline.getPoints().size() - 1) return true;
        }
        if (!this.getPoints().get(0).equals(closedPolyline.getPoints().get(0))) return false;
        for (int i = 1; i < closedPolyline.getPoints().size(); i++) {
            if (!this.getPoints().get(i).equals(closedPolyline.getPoints().get(closedPolyline.getPoints().size() - i)))
                return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int sumX = this.getPoints().get(0).getX();
        int sumY = this.getPoints().get(0).getY();
        for (int i = 0; i < this.getPoints().size(); i++) {
            sumX += this.getPoints().get(i).getX();
            sumY += this.getPoints().get(i).getY();
        }
        return Objects.hash(this.length(), sumX, sumY);
    }
    public Iterator<Point> iteratorFrom(Point point) {
        int index = super.getPoints().indexOf(point);
        if (index == -1) throw new IllegalArgumentException("Такой точки нет");
        return new ClosedPolylineIterator(index);
    }

    private class ClosedPolylineIterator implements Iterator<Point> {
        private int index;

        public ClosedPolylineIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Point next() {
            List<Point> points = ClosedPolyline.super.getPoints();
            Point point = points.get(index);
            int size = points.size();
            index++;
            index %= size;
            return point;
        }
    }
}
