package ru.chichkov.Annotation;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({PARAMETER})
public @interface Value {
    String value() default "";
}
