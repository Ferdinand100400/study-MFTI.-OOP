package ru.chichkov.genericMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

// Задача 6.3.1
// Задача 6.3.2
// Задача 6.3.3
// Задача 6.3.4
public class GenericMethods {

    // Задача 6.3.1
    public static <T, R> List<R> function(List<T> list, Function<T, R> fun) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(fun.apply(t));
        }
        return result;
    }

    // Задача 6.3.2
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) result.add(t);
        }
        return result;
    }

    // Задача 6.3.3
    public static <T> Optional<T> reduction(List<T> list, BinaryOperator<T> operator) {
        if (list == null || list.isEmpty()) return Optional.empty();
        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = operator.apply(result, list.get(i));
        }
        return Optional.of(result);
    }

    // Задача 6.3.4

}
