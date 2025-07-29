package ru.chichkov.connection;

import ru.chichkov.exception.ClosedException;
import ru.chichkov.exception.LossOfConnectionException;

import java.util.Random;

// Задача 4.1.4
public class Connection {
    private final String addressConnection;
    private boolean openLink;

    public Connection(String addressConnection) {
        this.addressConnection = addressConnection;
        openLink = true;
    }

    public void close() {
        openLink = false;
    }

    public String info() throws LossOfConnectionException {
        if (!openLink) throw new ClosedException();
        Random random = new Random();
        if (random.nextBoolean()) throw new LossOfConnectionException("Ошибка подключения!");
        return "test connection";
    }
}
