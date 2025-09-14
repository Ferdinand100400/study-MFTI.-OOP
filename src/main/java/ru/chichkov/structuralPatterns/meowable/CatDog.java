package ru.chichkov.structuralPatterns.meowable;

import ru.chichkov.animal.meow.Cat;
import ru.chichkov.animal.dog.Dog;
import ru.chichkov.animal.meow.GavAnimals;
import ru.chichkov.animal.meow.MeowAnimals;

import java.beans.JavaBean;

// Задача 7.2.4

public class CatDog implements MeowAnimals, GavAnimals {
    private final Cat cat;
    private final Dog dog;

    public CatDog(String name) {
        this.cat = new Cat(name);
        this.dog = new Dog(name);
    }
    @Override
    public void meow() {
        cat.meow();
    }
    @Override
    public void gav() {
        dog.gav();
    }
}

