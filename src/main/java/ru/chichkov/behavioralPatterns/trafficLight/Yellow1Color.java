package ru.chichkov.behavioralPatterns.trafficLight;

// Задача 7.3.9
public class Yellow1Color implements Color {
    @Override
    public Color next() {
        return new RedColor();
    }

    @Override
    public String toString() {
        return "Желтый";
    }
}
