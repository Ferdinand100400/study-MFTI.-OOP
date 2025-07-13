package studyMFTI;

// Задача 1.5.8
// Задача 1.6.3
public class Square {
    Point leftTopPoint;
    int lengthSide;

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

    public Polyline getPolyline() {
        int xRight = leftTopPoint.getX() + lengthSide;
        int yDown = leftTopPoint.getY() - lengthSide;
        return new Polyline(leftTopPoint, new Point(xRight, leftTopPoint.getY()),
                new Point(xRight, yDown), new Point(leftTopPoint.getX(), yDown), leftTopPoint);
    }
}
