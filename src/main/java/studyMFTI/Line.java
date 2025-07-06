package studyMFTI;

// Задача 1.2.1
// Задача 1.4.2
public class Line {
    private Point startPoint;
    private Point endPoint;

    public Line(Point point1, Point point2) {
        this.startPoint = point1;
        this.endPoint = point2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        startPoint = new Point(x1, y1);
        endPoint = new Point(x2, y2);
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
}
