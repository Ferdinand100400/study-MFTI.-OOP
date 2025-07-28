package ru.chichkov.weapon;

import lombok.Getter;
import lombok.Setter;

// Задача 2.3.8
@Getter
@Setter
public class Shooter {
    private String name;
    private Weapon weapon;

    public Shooter(String name) {
        this.name = name;
    }
    public void shoot() {
        if (this.weapon == null) {
            System.out.println("Не могу учавствовать в перестрелке");
            return;
        }
        this.weapon.shoot();
    }
}
