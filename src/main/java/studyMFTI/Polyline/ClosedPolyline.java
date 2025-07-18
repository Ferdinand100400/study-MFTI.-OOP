package studyMFTI.Polyline;

import studyMFTI.Line;
import studyMFTI.Point.Point;

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
        return super.length() + (new Line(super.getPoints().get(0), super.getPoints().get(getPoints().size() - 1))).length();
    }
}
