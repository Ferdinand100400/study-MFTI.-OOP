package ru.chichkov.database;

import java.util.ArrayList;
import java.util.List;

// Задача 7.1.6
public class Database {

    private List<String> data = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    private int maxConnection;
    private int countOpenConnection;

    public Database(int maxConnection) {
        this.maxConnection = maxConnection;
    }

    public ConnectionBD getConnection() {
        if (maxConnection <= countOpenConnection) return null;
        countOpenConnection++;
        return new ConnectionBDImpl();
    }

    class ConnectionBDImpl implements ConnectionBD {
        private boolean isOpen = true;
        private ConnectionBDImpl() {
        }

        @Override
        public String get(int index) {
            if (index < 0 || index > data.size() - 1 || !isOpen) return null;
            return data.get(index);
        }

        @Override
        public void add(String value) {
            if (isOpen) data.add(value);
        }

        @Override
        public void close() throws Exception {
            isOpen = false;
            countOpenConnection--;
        }
    }
}
