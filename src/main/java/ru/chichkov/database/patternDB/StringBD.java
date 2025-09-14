package ru.chichkov.database.patternDB;

// Задача 7.3.1
public class StringBD implements InterfaceBD {
    @Override
    public <T> T convert(String element) {
        return (T) element;
    }
}
