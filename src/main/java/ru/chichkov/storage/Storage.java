package ru.chichkov.storage;

// Задача 6.1.2
// Задача 7.1.1
public final class Storage<T> {

    private final T object;
    private static boolean onlyOneObjectIsNull = false;

    public Storage(T object, boolean allowNull) {
        if (object == null && (!allowNull || onlyOneObjectIsNull)) throw new IllegalArgumentException("Невозможно хранить null");
        if (object == null) onlyOneObjectIsNull = true;
        this.object = object;
    }

    public T getObject(T alterValue) {
        if (object == null) return alterValue;
        return object;
    }
}