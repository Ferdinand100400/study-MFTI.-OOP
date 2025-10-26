package ru.chichkov.dataTransformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// Задача 9.2.6
@Component
public class DataProcessor {

    private final DataReader dataReader;
    private final DataWriter dataWriter;
    private final List<DataTransformer> transformers;

    @Autowired
    public DataProcessor(DataReader dataReader, DataWriter dataWriter, List<DataTransformer> transformers) {
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.transformers = transformers;
    }

    public void processData(String source, String destination) {
        // 1. Чтение данных
        String data = dataReader.readData(source);

        // 2. Преобразование данных (последовательное применение цепочки преобразователей)
        for (DataTransformer transformer : transformers) {
            data = transformer.apply(data);
        }

        // 3. Запись данных
        dataWriter.writeData(data, destination);
    }
}