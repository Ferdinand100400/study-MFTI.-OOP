package ru.chichkov.ConfigurationString;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class Configurations {

    // Задача 9.1.1
    @Bean
    public String helloWorld() {
        return "Hello world";
    }
    // Задача 9.1.2
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)   // Каждый раз при обращении создаем новый бин, можно так: @Scope("prototype")
    public int random() {
        Random random = new Random();
        return random.nextInt(100);
    }
    // Задача 9.1.3
    @Bean
    @Lazy    // Создаем бин когда потребуется, по умолчанию он создается при создании контекста
    public Date start() {
        return new Date();
    }
    // Задача 9.1.4
    @Bean
    public Predicate<Integer> range() {
        return x -> (x >= 2 && x <= 5);
    }
    // Задача 9.1.5
    @Bean
    public int max() {
        return 100;
    }
    // Задача 9.1.5
    @Bean
    public int min() {
        return 0;
    }
}
