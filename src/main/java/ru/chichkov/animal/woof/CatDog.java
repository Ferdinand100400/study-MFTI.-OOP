package ru.chichkov.animal.woof;

import ru.chichkov.animal.meow.Cat;
import ru.chichkov.animal.meow.MeowAnimals;
import ru.chichkov.animal.meow.WoofAnimals;

public class CatDog implements MeowAnimals, WoofAnimals {
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
    public void woof() {
        dog.woof();
    }
}
