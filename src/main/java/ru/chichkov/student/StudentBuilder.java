package ru.chichkov.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Задача 9.2.5
@Component
public class StudentBuilder {
    private final Rule defaultRule;

    @Autowired
    public StudentBuilder(@Qualifier("rangeRule") Rule defaultRule) {
        this.defaultRule = defaultRule;
    }

    public Student createStudent(String name, int... marks) {
        return new Student(name, defaultRule, marks);
    }

    public Student createStudent(String name) {
        return new Student(name, defaultRule);
    }
}
