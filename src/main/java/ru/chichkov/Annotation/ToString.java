package ru.chichkov.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Задача 8.2.3
@Retention(RUNTIME)
@Target({TYPE, FIELD})
public @interface ToString {
    enum Value {
        YES, NO
    }
    Value value() default Value.YES;
}
