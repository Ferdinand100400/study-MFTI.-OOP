package ru.chichkov.animals.Bird;

// Задача 2.3.2
public class Birds {

    public static void birds(Bird... birds) {
        for (Bird bird: birds) {
            bird.sing();
        }
    }
}
