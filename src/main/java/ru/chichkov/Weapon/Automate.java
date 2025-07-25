package ru.chichkov.Weapon;

import lombok.Getter;

// Задача 2.1.4
public class Automate extends Gun{
    @Getter
    private final int rateOfFire;

    public Automate(int maxCount, int rateOfFire) {
        super(maxCount);
        if (rateOfFire < 0) throw new IllegalArgumentException("Скорострельность не может быть меньше 0");
        this.rateOfFire = rateOfFire;
    }
    public Automate(int maxCount) {
        this(maxCount, maxCount / 2);
    }
    public Automate() {
        this(30, 30);
    }

    @Override
    public void shoot() {
        this.shoot(1);
    }

    public void shoot(int time) {
        if (time < 0) throw new IllegalArgumentException("Время не может быть меньше 0");
        for (int i = 0; i < time * rateOfFire; i++) {
            super.shoot();
        }
    }
}
