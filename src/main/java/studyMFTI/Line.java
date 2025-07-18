package studyMFTI;


import lombok.Getter;
import studyMFTI.Point.Point;

import static java.lang.Math.*;

// Задача 1.2.1
// Задача 1.4.2
// Задача 1.5.3
// Задача 1.6.6
@Getter
public class Line {
    private Point startPoint;
    private Point endPoint;

    public Line(Point point1, Point point2) {
        startPoint = new Point(point1.getX(), point1.getY());
        endPoint = new Point(point2.getX(), point2.getY());
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint.getX(), startPoint.getY());
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = new Point(endPoint.getX(), endPoint.getY());
    }
    public int length() {
        return (int) abs(sqrt(pow(startPoint.getX() - endPoint.getX(), 2) + pow(startPoint.getY() - endPoint.getY(), 2)));

    }
}
