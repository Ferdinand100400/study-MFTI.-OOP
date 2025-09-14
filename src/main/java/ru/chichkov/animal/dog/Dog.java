package ru.chichkov.animal.dog;

import ru.chichkov.animal.meow.GavAnimals;

// Задача 7.2.4
public class Dog implements GavAnimals {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Собака: " + name;
    }
    @Override
    public void gav() {
        System.out.println(name + ": гав!");
    }
}
