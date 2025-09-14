package ru.chichkov.geometry.polyline;

import lombok.Getter;
import ru.chichkov.geometry.InterfaceLength;
import ru.chichkov.geometry.Line;
import ru.chichkov.geometry.point.Point;

import java.util.*;

// Задача 1.3.2
// Задача 1.4.3
// Задача 1.5.7
// Задача 2.1.2
// Задача 2.3.5
// Задача 5.1.4
// Задача 7.3.12
public class Polyline implements InterfaceLength, Iterable<Point> {
    @Getter
    private List<Point> points;

    public Polyline() {
        points = new ArrayList<>();
    }

    public Polyline(Point... points) {
        if (points.length == 0) return;
        this.points = new ArrayList<>();
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public String toString() {
        if (points == null) return "Линия []";
        String res = "Линия [";
        for (int i = 0; i < points.size() - 1; i++) {
            res += points.get(i) + ",";
        }
        res += points.get(points.size() - 1) + "]";
        return res;
    }

    public void setPoint(int index, Point point) {
        if (index >= this.points.size() || index < 0) {
            if (index > this.points.size() || index < 0) throw new ArrayIndexOutOfBoundsException();
            points.add(point);
            return;
        }
        points.set(index, point);
    }

    public void setPointLink(int index, Point point, Polyline link) {
        setPoint(index, point);
        link.setPoint(index, point);
    }

    public void addPoints(Point... points) {
        this.points.addAll(Arrays.asList(points));
    }

    public void addPoints(List<Point> points) {
        this.points.addAll(points);
    }

    @Override
    public int length() {
        int res = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Line line = new Line(points.get(i), points.get(i + 1), Point.class);
            res += line.length();
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Polyline polyline)) return false;
        int k = 0;
        if (o.getClass().getName().equals("ru.chichkov.geometry.polyline.ClosedPolyline")) k = 1;
        if (points.size() != polyline.points.size() + k) return false;
        for (int i = 0; i < points.size(); i++) {
            if (k == 1) {
                if (i == points.size() - 1 && points.get(i).equals(polyline.points.get(0))) {
                    return true;
                }
                if (i == points.size() - 1) return false;
            }
            if (!points.get(i).equals(polyline.points.get(i))) break;
            if (i == points.size() - 1) return true;
        }
        for (int i = 0; i < points.size(); i++) {
            if (k == 1 && !points.get(0).equals(polyline.points.get(0))) return false;
            if (i != 0 && !points.get(i).equals(polyline.points.get(polyline.points.size() - i - 1 + k))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < points.size(); i++) {
            sumX += points.get(i).getX();
            sumY += points.get(i).getY();
        }
        return Objects.hash(this.length(), sumX, sumY);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
    public Iterator<Point> iteratorFrom(Point point) {
        int index = points.indexOf(point);
        if (index == -1) throw new IllegalArgumentException("Такой точки нет");
        return new PolylineIterator(index);
    }
    private class PolylineIterator implements Iterator<Point> {
        private int index;

        public PolylineIterator(int index) {
            index--;
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return points.size() - 1 > index;
        }

        @Override
        public Point next() {
            index++;
            return points.get(index);
        }
    }
}