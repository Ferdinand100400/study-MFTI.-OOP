package studyMFTI;

// Задача 1.5.8
public class Square {
    Point leftTopPoint;
    int lengthSide;

    public Square(Point pointLeftTop, int lengthSide) {
        this.leftTopPoint = pointLeftTop;
        this.lengthSide = lengthSide;
    }

    public Square(int x, int y, int lengthSide) {
        this(new Point(x, y), lengthSide);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + leftTopPoint + " со стороной " + lengthSide;
    }


    public Polyline getPolyline() {
        int xRight = leftTopPoint.getX() + lengthSide;
        int yDown = leftTopPoint.getY() - lengthSide;
        return new Polyline(leftTopPoint, new Point(xRight, leftTopPoint.getY()),
                new Point(xRight, yDown), new Point(leftTopPoint.getX(), yDown), leftTopPoint);
    }
}
