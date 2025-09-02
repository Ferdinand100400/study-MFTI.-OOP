package ru.chichkov.DataStream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

// Задача 6.3.1
// Задача 6.3.2
// Задача 6.3.3
// Задача 6.3.4
public class DataStream<T> {
    private Iterator<T> iter;
    private List<Function<T, Result>> functions = new ArrayList<>();

    private DataStream(Iterator<T> iter) {
        this.iter = iter;
    }
    public static <T> DataStream<T> of(List<T> elements) {
        return new DataStream<>(elements.iterator());
    }
    public static <T> DataStream<T> of(Iterator<T> iter) {
        return new DataStream<>(iter);
    }
    public static <T> DataStream<T> of(T... obj) {
        return DataStream.of(Arrays.asList(obj));
    }
    public static <T> DataStream<T> generate(Supplier<T> supplier) {
        T elements = supplier.get();
        return DataStream.of(elements);
    }

    // Задача 6.3.1 + upgrade
    public <R> DataStream<R> map(Function<T, R> applier) {
        functions.add(x -> new Result(false, applier.apply(x)));
        return (DataStream<R>) this;
    }

    // Задача 6.3.2 + upgrade
    public DataStream<T> filter(Predicate<T> filter) {
        functions.add(x -> {
            if (filter.test(x)) return new Result(false, x);
            return new Result(true, null);
        });
        return this;
    }

    // Задача 6.3.3 + upgrade
    public T reduce(BinaryOperator<T> operator) {
        T result = null;
        boolean isFirstElement = true;
        Result element;
        while (iter.hasNext()) {
            element = applyFunctions(iter.next());
            if (element.isEmpty()) continue;
            if (isFirstElement) {
                result = (T) element.result;
                isFirstElement = false;
            } else {
                result = operator.apply(result, (T) element.result);
            }
        }
        return result;
    }

    // Задача 6.3.4
    public <P> P collect(Supplier<P> creator, BiConsumer<P, T> putter) {
        P collection = creator.get();
        Result element;
        while (iter.hasNext()) {
            element = applyFunctions(iter.next());
            if (element.isEmpty()) continue;
            putter.accept(collection, (T) element.result);
        }
        return collection;
    }

    private Result applyFunctions(T element) {
        Result result = new Result(false, null);
        for (Function<T, Result> fun: functions) {
            result = fun.apply(element);
            if (result.isEmpty()) return result;
            element = (T) result.result();
        }
        return result;
    }

    record Result(boolean isEmpty, Object result) {
    }
}
