package ru.chichkov.dataTransformation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Задача 9.2.6
@Component
@Order(1)
public class ToUpperCaseTransformer implements DataTransformer {
    @Override
    public String apply(String data) {
        return data.toUpperCase();
    }
}
