package ru.chichkov.geometry;

// Задача 7.2.2
public class LengthStrings implements InterfaceLength {
    private final String string;

    public LengthStrings(String string) {
        this.string = string;
    }

    @Override
    public int length() {
        return string.length();
    }
}
