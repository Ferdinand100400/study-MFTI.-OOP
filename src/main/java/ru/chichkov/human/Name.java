package ru.chichkov.human;

// Задача 1.1.3
// Задача 1.4.5
// Задача 1.6.2
// Задача 7.1.9
public class Name {
    private final String surname;
    private final String name;
    private final String patronymic;

    private Name(String name, String surname, String patronymic) {
        if (surname == null) surname = "";
        if (name == null) name = "";
        if (patronymic == null) patronymic = "";
        if ((surname.isEmpty() && name.isEmpty() && patronymic.isEmpty()))
            throw new IllegalArgumentException("Хотя бы один из параметров должен быть не null или не пустым");
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public static Name of(String name, String surname, String patronymic) {
        return new Name(name, surname, patronymic);
    }
    public static Name of(String name, String surname) {
        return new Name(name, surname, "");
    }

    public static Name of(String name) {
        return new Name(name, "", "");
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
