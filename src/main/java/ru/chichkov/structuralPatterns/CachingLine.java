package ru.chichkov.structuralPatterns;

import ru.chichkov.geometry.InterfaceLength;
import ru.chichkov.geometry.Line;
import ru.chichkov.geometry.point.Point;

public class CachingLine<T extends Point> implements InterfaceLength {
    private Line<T> line;
    private boolean changeLine;
    private int length;

    public CachingLine(InterfaceLength line) {
        this.line = (Line<T>) line;
        changeLine = true;
    }
    public void setStartPoint(T startPoint) {
        line.setStartPoint(startPoint);
        changeLine = true;
    }
    public void setEndPoint(T endPoint) {
        line.setEndPoint(endPoint);
        changeLine = true;
    }

    @Override
    public int length() {
        if (changeLine) length = line.length();
        changeLine = false;
        return length;
    }
}
