package ru.chichkov.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Задача 8.2.2
@Retention(RUNTIME)
@Target({TYPE, FIELD})
public @interface Default {
    Class<?> value();
}
