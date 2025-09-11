package ru.chichkov.human;

public interface FullNameBuilder {
    FullNameBuilder firstName(String firstName);
    FullNameBuilder surname(String surname);
    FullNameBuilder patronymic(String patronymic);
    Name build();

}
