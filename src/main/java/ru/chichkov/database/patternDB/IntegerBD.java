package ru.chichkov.database.patternDB;

// Задача 7.3.1
public class IntegerBD implements InterfaceBD {
    @Override
    public <T> T convert(String element) {
        Integer res = (Integer) element.length();
        return (T) res;
    }
}
