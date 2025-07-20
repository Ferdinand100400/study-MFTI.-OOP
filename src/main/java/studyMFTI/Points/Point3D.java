package studyMFTI.Points;

import lombok.Getter;

public class Point3D extends Point2D {
    @Getter
    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + super.getX() + ";" + super.getY() + ";" + z + "}" + ", color: "
                + super.getColor() + ", size: " + super.getSize();
    }
}

