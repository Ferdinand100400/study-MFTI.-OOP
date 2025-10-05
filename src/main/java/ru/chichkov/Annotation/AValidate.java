package ru.chichkov.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Аннотация-псевдоним
@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface AValidate {
}
