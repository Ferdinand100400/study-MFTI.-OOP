package ru.chichkov.database.patternDB;

import java.util.ArrayList;
import java.util.List;

public class DatabasePattern {
    private List<String> listColumn;
    private InterfaceBD interfaceBD;

    public DatabasePattern() {
        this.listColumn = new ArrayList<>();
    }
    public DatabasePattern(List<String> listColumn) {
        this();
        this.listColumn = listColumn;
    }
    public void addValue(String value) {
        listColumn.add(value);
    }
    public <T> T get(int index, Class<T> type) {
        return interfaceBD.convert(listColumn.get(index), type);
    }
}
