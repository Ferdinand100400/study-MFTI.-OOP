package studyMFTI.Points;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;

// Задача 2.2.5
@Data
public class Point1D {
    private final int x;
    private String color;
    private int size;

    public void setSize(int size) {
        if (size < 0) throw new IllegalArgumentException("Размер не может быть меньше 0");
        this.size = size;
    }

    @Override
    public String toString() {
        return "{" + x + "}" + ", color: " + color + ", size: " + size;
    }
}
