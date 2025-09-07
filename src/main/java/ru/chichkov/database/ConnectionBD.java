package ru.chichkov.database;

// Задача 7.1.6
public interface ConnectionBD extends AutoCloseable {
    String get(int index);
    void add(String value);
}
