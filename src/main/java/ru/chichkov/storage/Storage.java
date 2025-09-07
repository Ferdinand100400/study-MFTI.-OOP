package ru.chichkov.storage;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;

// Задача 6.1.2
// Задача 7.1.1
public final class Storage<T> {

    private final Callable<T> object;
    private static Storage empty = new Storage(null);

    private Storage(Callable<T> object) {
        this.object = object;
    }
    public static <T> Storage<T> empty() {
        return empty;
    }
    public static <T> Storage<T> of(T object) {
        if (object == null) throw new IllegalArgumentException("Невозможно хранить null");
        return new Storage<>(() -> object);
    }
    public static <T> Storage<T> lazy(Callable<T> object) {
        if (object == null) throw new IllegalArgumentException("Невозможно хранить null");
        return new Storage<>(object);
    }
    public static <T> Storage<T> ofNullable(T object) {
        if (object == null) return empty;
        return new Storage<>(() -> object);
    }

    @SneakyThrows
    public T getObject(T alterValue) {
        return object == null ? alterValue : object.call();
    }
}