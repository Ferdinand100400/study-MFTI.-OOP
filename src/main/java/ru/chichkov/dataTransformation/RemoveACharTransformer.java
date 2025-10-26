package ru.chichkov.dataTransformation;

// Задача 9.2.6
public class RemoveACharTransformer implements DataTransformer {
    @Override
    public String apply(String data) {
        return data.replace("A", "");
    }
}
