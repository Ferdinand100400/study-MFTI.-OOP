package ru.chichkov;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.chichkov.dataTransformation.DataProcessor;

public class DataTransformerTest {
    ApplicationContext context = new AnnotationConfigApplicationContext("ru.chichkov.dataTransformation");

    @Test
    public void test() {
        DataProcessor dataProcessor = (DataProcessor) context.getBean("dataProcessor");
        dataProcessor.processData("src/main/resources/input.txt", "src/main/resources/output.txt");

    }
}
