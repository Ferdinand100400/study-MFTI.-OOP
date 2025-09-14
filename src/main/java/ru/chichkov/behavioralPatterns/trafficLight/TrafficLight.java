package ru.chichkov.behavioralPatterns.trafficLight;

// Задача 7.3.9
public class TrafficLight {
    Color color = new GreenColor();

    public void next() {
        System.out.println(color.toString());
        color = color.next();
    }
}
