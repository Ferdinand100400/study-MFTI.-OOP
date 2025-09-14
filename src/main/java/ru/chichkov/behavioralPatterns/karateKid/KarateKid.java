package ru.chichkov.behavioralPatterns.karateKid;

// Задача 7.3.2
public class KarateKid {
    private final String name;

    public KarateKid(String name) {
        this.name = name;
    }
    public void beatLegs() {
        System.out.println(name + ": бац!");
    }

    public void beatHand() {
        System.out.println(name + ": кия!");
    }
    public void beatInJump() {
        System.out.println(name + ": вжух!");
    }
}
