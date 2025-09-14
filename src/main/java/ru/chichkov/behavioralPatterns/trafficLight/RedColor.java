package ru.chichkov.behavioralPatterns.trafficLight;

// Задача 7.3.9
public class RedColor implements Color {
    @Override
    public Color next() {
        return new Yellow2Color();
    }

    @Override
    public String toString() {
        return "Красный";
    }
}
