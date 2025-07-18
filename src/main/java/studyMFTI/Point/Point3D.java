package studyMFTI.Point;

import lombok.Getter;

// Задача 2.1.5
public final class Point3D extends Point {
    @Getter
    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public String toString() {
        return "{" + super.getX() + ";" + super.getY() + ";" + z + "}";
    }
}
