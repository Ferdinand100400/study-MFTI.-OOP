package ru.chichkov.ConfigurationString;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class Configurations {

    @Bean
    public String helloWorld() {
        return "Hello world";
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public int random() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Date start() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return x -> (x >= 2 && x <= 5);
    }

    @Bean
    public int max() {
        return 100;
    }

    @Bean
    public int min() {
        return 0;
    }
}
