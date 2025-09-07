package ru.chichkov.human;

import lombok.Getter;

// Задача 1.1.2; 1.2.2; 1.2.3
// Задача 1.4.6
// Задача 1.5.4
// Задача 1.6.7
// Задача 7.1.9
@Getter
public class Human {

    private final Name name;
    private final Human father;

    public Human(Name name, Human father) {
        this.name = name;
        this.father = father;
    }
    public Human(String name, Human father) {
        this(Name.of(name), father);
    }
    public Human(Name name) {
        this(name, null);
    }
    public Human(String name) {
        this(Name.of(name));
    }

    @Override
    public String toString() {
        return this.getSurname() + " " + this.getOwenName() + " " + this.getPatronymic();
    }

    public String getOwenName() {
        return name.getName();
    }

    public String getSurname() {
        if (name.getSurname() != null && !name.getSurname().isEmpty()) return name.getSurname();
        if (father == null) return "";
        return father.getSurname();
    }

    public String getPatronymic() {
        if (name.getPatronymic() != null && !name.getPatronymic().isEmpty()) return name.getPatronymic();
        if (father == null) return "";
        return father.getOwenName() + "ович";
    }
}
