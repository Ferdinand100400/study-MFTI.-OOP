package ru.chichkov.behavioralPatterns.karateKid;

import java.util.ArrayList;
import java.util.List;

// Задача 7.3.2
public class Combination {
    private final List<TypeBeat> beats = new ArrayList<>();

    public void addBead(TypeBeat typeBeat) {
        beats.add(typeBeat);
    }

    public void removeBeat(TypeBeat typeBeat) {
        beats.remove(typeBeat);
    }

    public void beat(KarateKid karateKid) {
        for (TypeBeat beat : beats) {
            beat.beat(karateKid);
        }
    }
    public void deleteBeats() {
        beats.clear();
    }
}
