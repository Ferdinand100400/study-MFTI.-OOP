package ru.chichkov.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Задача 8.2.4
@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
public @interface Validate {
    Class[] value();
}
