package ru.chichkov.human;

import jakarta.persistence.Embeddable;

// Задача 1.1.3
// Задача 1.4.5
// Задача 1.6.2
// Задача 7.1.9
@Embeddable
public class Name {
    private String surname;
    private String name;
    private String patronymic;

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
    private Name() {}

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

    public static FullNameBuilder builder() {
        return new Builder();
    }
    private static class Builder implements FullNameBuilder {
        private String surname = "";
        private String name = "";
        private String patronymic = "";
        @Override
        public FullNameBuilder firstName(String firstName) {
            if (firstName == null) return this;
            this.name = firstName;
            return this;
        }

        @Override
        public FullNameBuilder surname(String surname) {
            if (surname == null) return this;
            this.surname = surname;
            return this;
        }

        @Override
        public FullNameBuilder patronymic(String patronymic) {
            if (patronymic == null) return this;
            this.patronymic = patronymic;
            return this;
        }

        @Override
        public Name build() {
            return new Name(this.name, this.surname, this.patronymic);
        }
    }
}
