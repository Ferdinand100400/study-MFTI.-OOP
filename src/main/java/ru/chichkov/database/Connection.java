package ru.chichkov.database;

// Задача 7.1.6
public class Connection {
    private Database database;
    private static int countConnection = 1;

    public Connection(Database database) {
        if (countConnection > database.maxConnection) return;
        this.database = database;
        countConnection++;
    }
    public String getValue(int index) {
        if (this.database == null || index >= database.listColumn.size()) return null;
        return database.listColumn.get(index);
    }
    public void addValue(String value) {
        if (this.database != null) database.listColumn.add(value);
    }
}
