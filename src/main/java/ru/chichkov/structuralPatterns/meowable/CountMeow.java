package ru.chichkov.structuralPatterns.meowable;

import lombok.Getter;
import ru.chichkov.animal.meow.MeowAnimals;

// Задача 7.2.3
public class CountMeow implements MeowAnimals {
    private final MeowAnimals cat;
    @Getter
    private int countMeow;

    public CountMeow(MeowAnimals cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        countMeow++;
        cat.meow();
    }
}
