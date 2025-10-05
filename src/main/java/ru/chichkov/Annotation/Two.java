package ru.chichkov.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Задача 8.2.5
@Retention(RUNTIME)
@Target({TYPE})
public @interface Two {
    String first();
    int second();
}
