package ru.chichkov.geometry.Points;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// Задача 2.2.5
@Data
public class Point1D {
    private final int x;
    List<Attribute> attributeLine = new ArrayList<>();

    @Override
    public String toString() {
        return "{" + x + "}";
    }

    public void addAttributeLine(Attribute attributeLine) {
        this.attributeLine.add(attributeLine);
    }
}

