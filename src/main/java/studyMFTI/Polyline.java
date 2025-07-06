package studyMFTI;

import java.util.ArrayList;
import java.util.List;

// Задача 1.3.2
// Задача 1.4.3
public class Polyline {
    private List<Point> points = new ArrayList<>();

    public Polyline() {}
    public Polyline(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
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
        link.setPoint(index,point);
    }

    public List<Point> getPoints() {
        return points;
    }
}
