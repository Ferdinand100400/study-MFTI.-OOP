package ru.chichkov.storage;

// Задача 6.1.2
public final class Storage<T> {

    private final T object;

    public Storage(T object) {
        this.object = object;
    }

    public T getObject(T alterValue) {
        if (object == null) return alterValue;
        return object;
    }
}