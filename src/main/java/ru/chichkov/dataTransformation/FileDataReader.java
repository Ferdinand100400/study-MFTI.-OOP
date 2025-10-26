package ru.chichkov.dataTransformation;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;

@Component
class FileDataReader implements DataReader {
    @Override
    public String readData(String source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException("Ошибка чтения из файла: " + source, e);
        }
    }
}
