package ru.chichkov.behavioralPatterns.trafficLight;

// Задача 7.3.9
public class Yellow2Color implements Color {
    @Override
    public Color next() {
        return new GreenColor();
    }

    @Override
    public String toString() {
        return "Желтый";
    }
}