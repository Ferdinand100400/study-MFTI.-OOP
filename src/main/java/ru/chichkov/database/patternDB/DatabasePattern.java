package ru.chichkov.database.patternDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// Задача 7.3.1
public class DatabasePattern {
    private final List<String> data = new ArrayList<>();
    private final Map<Class<?>, Function<String, ?>> converters = new HashMap<>();

    public DatabasePattern(List<String> data) {
        this.data.addAll(data);
    }
    public void addValue(String value) {
        data.add(value);
    }
    public <T> void addConverter(Class<T> type, Function<String, T> converter) {
        converters.put(type, converter);
    }
    public <T> T get(int index, Class<T> type) {
        if (index < 0 || index >= data.size()) throw new IllegalArgumentException("Такого индекса нет");
        String elem = data.get(index);
        Function<String, ?> converter = converters.get(type);
        if (converter == null) throw new IllegalArgumentException("Такого преобразования нет");
        return type.cast(converter.apply(elem));
    }
}
