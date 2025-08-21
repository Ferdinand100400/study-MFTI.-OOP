package ru.chichkov.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Задача 7.1.6
public class Database {

    protected List<String> listColumn;
    protected int maxConnection;

    public Database(int maxConnection) {
        this.listColumn = new ArrayList<>();
        listColumn.addAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        this.maxConnection = maxConnection;
    }
}
