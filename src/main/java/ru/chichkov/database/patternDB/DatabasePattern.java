package ru.chichkov.database.patternDB;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

// Задача 7.3.1
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
        return convert(listColumn.get(index), interfaceBD::convert);
    }
    private  <R> R convert(String element, Function<String, R> function) {
        return function.apply(element);
    }
}
