package ru.chichkov.DataStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

// Задача 6.3.1
// Задача 6.3.2
// Задача 6.3.3
// Задача 6.3.4
public class DataStream<T> {

    private List<T> elements;
    private List<Function> functions = new ArrayList<>();
    private List<Predicate> filters = new ArrayList<>();

    private DataStream(List<T> elements) {
        this.elements = elements;
    }
    public static <T> DataStream<T> of(List<T> elements) {
        return new DataStream<>(elements);
    }

    // Задача 6.3.1 + upgrade
    public <R> DataStream<R> map(Function<T, R> applier) {
        functions.add(applier);
        return (DataStream<R>) this;
    }

    // Задача 6.3.2 + upgrade
    public DataStream<T> filter(Predicate<T> filter) {
        filters.add(filter);
        return (DataStream<T>) this;
    }

    // Задача 6.3.3 + upgrade
    public Optional<T> reduce(BinaryOperator<T> operator) {
        if (elements == null || elements.isEmpty()) return Optional.empty();
        T result = elements.get(0);
        if (!functions.isEmpty()) result = (T) functions.get(0).apply(elements.get(0));
        for (int i = 1; i < elements.size(); i++) {
            Object obj = elements.get(i);
            boolean filterTest = true;
            for (Function fun: functions) obj = fun.apply(obj);
            for (Predicate filter: filters)
                if (!filter.test(obj)) filterTest = false;
            if (filterTest) result = operator.apply(result, (T) obj);
        }
        return Optional.of(result);
    }

    // Задача 6.3.4
    public <P> P collect(Supplier<P> creator, BiConsumer<P, T> putter) {
        P collection = creator.get();
        for (Object obj: elements) {
            boolean filterTest = true;
            for (Function fun: functions) obj = fun.apply(obj);
            for (Predicate filter: filters)
                if (!filter.test(obj)) filterTest = false;
            if (filterTest) putter.accept(collection, (T) obj);
        }
        return collection;
    }
}
