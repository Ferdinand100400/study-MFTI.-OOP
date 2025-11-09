package ru.chichkov.dataTransformation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

// Задача 9.2.6
@Component
@Order(3)
public class FilterLongWordsTransformer implements DataTransformer {
    @Override
    public String apply(String data) {
        return Arrays.stream(data.split("\\s+"))
                .filter(word -> word.length() > 4)
                .collect(Collectors.joining(" "));
    }
}
