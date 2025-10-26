package ru.chichkov.behavioralPatterns.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Задача 7.3.9
// Задача 9.2.7
@Component
@Qualifier("Green")
public class GreenColor implements Color {
    private Color next;
    @Autowired
    public void setNext(@Qualifier("Yellow") Color next) {
        this.next = next;
    }

    @Override
    public Color next() {
        return next;
    }

    @Override
    public String toString() {
        return "Зеленый";
    }
}
