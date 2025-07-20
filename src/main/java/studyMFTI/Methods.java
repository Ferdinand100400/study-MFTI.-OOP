package studyMFTI;

import studyMFTI.Bird.Bird;
import studyMFTI.MeowAnimals.MeowAnimals;
import studyMFTI.Shape.Shape;

// Задача 2.3.1
// Задача 2.3.2
public interface Methods {

    // Задача 2.3.1
    static double sum(Object... value) {
        double res = 0.0;
        for (Object val : value) {
            if (!(val.getClass().equals(Integer.class) || val.getClass().equals(Double.class) || val.getClass().equals(Fraction.class)))
                throw new IllegalArgumentException();
            if (val.getClass().equals(Fraction.class)) {
                Fraction fraction = new Fraction(0, 1);
                fraction = fraction.sum((Fraction) val);
                res += fraction.doubleValue();
            } else res += Double.parseDouble(val.toString());
        }
        return res;
    }

    // Задача 2.3.2
    static void birds(Bird... birds) {
        for (Bird bird: birds) {
            bird.sing();
        }
    }

    // Задача 2.3.3
    static double generalSquare(Shape... shapes) {
        double res = 0;
        for (Shape shape: shapes) {
            res += shape.square();
        }
        return res;
    }
}
