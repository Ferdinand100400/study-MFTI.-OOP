package ru.chichkov.dataTransformation;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;

// Задача 9.2.6
@Component
class FileDataWriter implements DataWriter {

    @Override
    public void writeData(String data, String source) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source))) {
            writer.write(data);
        } catch (IOException e) {
            throw new UncheckedIOException("Ошибка записи в файл: " + source, e);
        }
    }
}