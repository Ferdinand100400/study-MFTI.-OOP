package ru.chichkov.storage;

// Задача 6.1.1
public class Box<T> {
    private T object = null;

    public T getObject() {
        T object = (T) this.object;
        this.object = null;
        return object;
    }

    public void setObject(T object) {
        if (isOverflowing()) throw new IllegalArgumentException("Коробка не пуста!");
        this.object = object;
    }

    public boolean isOverflowing() {
        return this.object != null;
    }
}
