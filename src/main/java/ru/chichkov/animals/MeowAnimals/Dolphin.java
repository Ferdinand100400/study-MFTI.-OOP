package ru.chichkov.animals.MeowAnimals;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Задача 2.3.4
@AllArgsConstructor
public class Dolphin implements MeowAnimals {
    @Getter
    private String name;

    @Override
    public String toString() {
        return "Дельфин: " + name;
    }
    @Override
    public void meow() {
        System.out.println(name + ": миииу!");
    }
}
