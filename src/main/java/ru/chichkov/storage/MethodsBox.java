package ru.chichkov.storage;

import ru.chichkov.geometry.point.Point3D;

// Задача 6.2.2
// Задача 6.2.3
public class MethodsBox {

    // Задача 6.2.2
    public static double MaxValueFromBox(Box<? extends Number>... box) {
        if (box.length == 0) throw new IllegalArgumentException("Нет объектов типа коробка");
        double maxValue = box[0].getObject().doubleValue();
        for (int i = 1; i < box.length; i++) {
            double valueBox = box[i].getObject().doubleValue();
            if (valueBox > maxValue) maxValue = valueBox;
        }
        return maxValue;
    }

    // Задача 6.2.3
    public static void BoxWithPoint3D(Box<? super Point3D> box) {
        box.setObject(new Point3D(1, 2, 3));
    }
}
