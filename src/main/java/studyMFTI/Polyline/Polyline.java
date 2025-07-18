package studyMFTI.Polyline;

import lombok.Getter;
import studyMFTI.Line;
import studyMFTI.Point.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Задача 1.3.2
// Задача 1.4.3
// Задача 1.5.7
// Задача 2.1.2
public class Polyline {
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

    public int length() {
        int res = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Line line = new Line(points.get(i), points.get(i + 1));
            res += line.length();
        }
        return res;
    }
}