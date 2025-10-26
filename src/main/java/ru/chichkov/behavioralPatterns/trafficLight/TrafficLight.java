package ru.chichkov.behavioralPatterns.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Задача 7.3.9
// Задача 9.2.7
@Component
public class TrafficLight {
    private Color color;

    @Autowired
    public TrafficLight(@Qualifier("Green") Color color) {
        this.color = color;
    }

    public void next() {
        System.out.println(color.toString());
        color = color.next();
    }
}
