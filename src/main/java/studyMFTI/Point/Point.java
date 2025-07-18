package studyMFTI.Point;

import lombok.Data;

// Задача 1.1.1
// Задача 1.4.1
@Data
public sealed class Point permits Point3D {
    private final int x;
    private final int y;


    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

}

