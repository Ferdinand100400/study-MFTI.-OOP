package ru.chichkov.student;

import lombok.Getter;
import ru.chichkov.exception.NotCorrectMarksException;

import java.util.ArrayList;
import java.util.List;

// Задача 1.3.1
// Задача 1.4.7
// Задача 1.5.6
// Задача 1.6.8
// Задача 2.3.9
// Задача 4.1.1
public class Student {
    @Getter
    private final String name;
    @Getter
    private List<Integer> marks;
    private Rule rule;
//    private static final int MIN_GRADE = 2;
//    private static final int MAX_GRADE = 5;

    public Student(String name, int...marks) {
        this.name = name;
        this.rule = new NotRule();
        this.setMarks(marks);
    }
    public Student(String name, Rule rule, int...marks) {
        this.name = name;
        this.rule = rule;
        this.setMarks(marks);
    }

    public void setMarks(int...marks) {
        if (marks.length > 0) this.marks = new ArrayList<>();
        for (int i = 0; i < marks.length; i++) {
            this.setMarksIndex(i, marks[i]);
        }
    }
    public void setMarksIndex(int index, int mark) {
        if (index > marks.size()) throw new IllegalArgumentException("индекс больше количества оценок");
        if (index < 0) throw new IllegalArgumentException("индекс не может быть отрицательным");
        if (!this.rule.isCheck(mark)) throw new NotCorrectMarksException(this.name + "- оценка не удовлетворяет правилу");
        if (index == marks.size()) this.marks.add(mark);
        this.marks.set(index, mark);
    }

    public double averageMarks() {
        if (marks == null || marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark: marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public boolean isExcellentStudent() {
        return ((int) this.averageMarks() == this.rule.maxMark());
    }
}