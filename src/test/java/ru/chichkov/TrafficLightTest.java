package ru.chichkov;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.chichkov.behavioralPatterns.trafficLight.TrafficLight;

public class TrafficLightTest {
    ApplicationContext context = new AnnotationConfigApplicationContext("ru.chichkov.behavioralPatterns.trafficLight");

    @Test
    public void test() {
        TrafficLight trafficLight = context.getBean(TrafficLight.class);
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();

    }
}
