package ru.chichkov.behavioralPatterns.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Задача 7.3.9
// Задача 9.2.7
@Component
@Qualifier("Yellow")
public class YellowColor implements Color {
    private Color next1;
    private Color next2;
    private int count;

    @Autowired
    public void setNext1(@Qualifier("Green") Color next) {
        this.next1 = next;
    }
    @Autowired
    public void setNext2(@Qualifier("Red") Color next) {
        this.next2 = next;
    }
    @Override
    public Color next() {
        count++;
        if (count % 2 == 0) return next1;
        return next2;
    }

    @Override
    public String toString() {
        return "Желтый";
    }
}
