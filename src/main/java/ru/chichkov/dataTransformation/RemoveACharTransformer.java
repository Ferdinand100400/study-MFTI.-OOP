package ru.chichkov.dataTransformation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Задача 9.2.6
@Component
@Order(2)
public class RemoveACharTransformer implements DataTransformer {
    @Override
    public String apply(String data) {
        return data.replace("A", "");
    }
}
