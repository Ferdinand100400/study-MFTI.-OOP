package ru.chichkov.behavioralPatterns.trafficLight;

// Задача 7.3.9
public class GreenColor implements Color {
    @Override
    public Color next() {
        return new Yellow1Color();
    }

    @Override
    public String toString() {
        return "Зеленый";
    }
}
