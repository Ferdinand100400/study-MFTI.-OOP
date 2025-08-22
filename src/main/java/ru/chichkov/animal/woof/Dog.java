package ru.chichkov.animal.woof;

import ru.chichkov.animal.meow.WoofAnimals;

// Задача 7.2.4
public class Dog implements WoofAnimals {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Собака: " + name;
    }
    public void woof() {
        System.out.print(name + ": гав!");
    }
}
