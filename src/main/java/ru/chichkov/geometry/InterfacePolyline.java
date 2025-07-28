package ru.chichkov.geometry;

import ru.chichkov.geometry.polyline.Polyline;

// Задача 2.3.7
public interface InterfacePolyline {
    Polyline getPolyline();

    static Polyline generalPolyline(Square... squares) {
        Polyline polyline = new Polyline();
        for (Square p: squares) {
            polyline.addPoints(p.getPolyline().getPoints());
        }
        return polyline;
    }
}
