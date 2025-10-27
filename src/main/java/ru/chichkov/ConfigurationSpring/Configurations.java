package ru.chichkov.ConfigurationSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ru.chichkov.dataTransformation.DataProcessor;
import ru.chichkov.dataTransformation.DataReader;
import ru.chichkov.dataTransformation.DataTransformer;
import ru.chichkov.dataTransformation.DataWriter;
import ru.chichkov.reviews.Review;
import ru.chichkov.student.Rule;
import ru.chichkov.student.RuleRange;
import ru.chichkov.student.Student;
import ru.chichkov.student.StudentBuilder;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class Configurations {
    private List<Integer> listRandomValues = new ArrayList<>();

    // Задача 9.1.1
    @Bean
    public String helloWorld() {
        return "Hello world";
    }

    // Задача 9.1.2
    // Задача 9.2.1
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)   // Каждый раз при обращении создаем новый бин, или так: @Scope("prototype")
    @Qualifier("random")
    public int random(@Qualifier("min") int min, @Qualifier("max") int max) {
        if (listRandomValues.isEmpty()) {
            for (int i = min; i < max; i++) {
                listRandomValues.add(i);
            }
        }
        Random random = new Random();
        int index = random.nextInt(0, listRandomValues.size());
        return listRandomValues.get(index);
    }

    // Задача 9.1.3
    @Bean
    @Lazy    // Создаем бин когда потребуется, по умолчанию он создается при создании контекста
    public Date start() {
        return new Date();
    }

    // Задача 9.1.4
    @Bean
    @Qualifier("range")
    public Predicate<Integer> range() {
        return x -> (x >= 2 && x <= 5);
    }

    // Задача 9.1.5
    @Bean
    @Qualifier("max")
    public int max() {
        return 100;
    }

    // Задача 9.1.5
    @Bean
    @Qualifier("min")
    public int min() {
        return 0;
    }

    // Задача 9.2.2
    @Bean
    public Review goodReview() {
        return new Review("Очень хорошо", 4);
    }

    // Задача 9.2.2
    @Bean
    public Review satisfactoryReview() {
        return new Review("Сойдет", 3);
    }

    // Задача 9.2.2
    @Bean
    @Scope("prototype")
    @Qualifier("notKnownReview")
    public Review notKnownReview(@Qualifier("random") int mark) {
        return new Review("Сложно сказать", mark);
    }

    // Задача 9.2.3
    @Bean
    @Lazy
    public Review bestReview(@Autowired List<Review> reviews) {
        return reviews.stream()
                .max((r1, r2) -> Integer.compare(r1.getMark(), r2.getMark()))
                .get();
    }

    // Задача 9.2.4
    @Bean
    @Qualifier("ruleRange")
    public RuleRange ruleRange(@Qualifier("range") Predicate<Integer> range, @Qualifier("max") int max) {
        return new RuleRange(range, max);
    }

    // Задача 9.2.4
    @Bean
    public Student student1(@Qualifier("ruleRange") Rule rule) {
        return new Student("Вася", rule);
    }

    // Задача 9.2.4
    @Bean
    public Student student2(@Qualifier("ruleRange") Rule rule) {
        return new Student("Коля", rule);
    }

    // Задача 9.2.5
    @Bean
    public StudentBuilder studentBuilder(@Qualifier("ruleRange") Rule rule) {
        return new StudentBuilder(rule);
    }

    // Задача 9.2.6
    @Bean
    public DataProcessor dataProcessor(DataReader dataReader, DataWriter dataWriter,
                                       List<DataTransformer> transformers) {
        return new DataProcessor(dataReader, dataWriter, transformers);
    }
}
