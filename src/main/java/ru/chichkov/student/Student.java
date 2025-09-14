package ru.chichkov.student;

import lombok.Getter;
import lombok.Setter;
import ru.chichkov.behavioralPatterns.Action;
import ru.chichkov.behavioralPatterns.SaveStudent;
import ru.chichkov.behavioralPatterns.SaveStudentImpl;
import ru.chichkov.comparable.Comparable;
import ru.chichkov.exception.NotCorrectMarksException;
import ru.chichkov.geometry.point.Point;

import java.util.*;
import java.util.function.Consumer;

// Задача 1.3.1
// Задача 1.4.7
// Задача 1.5.6
// Задача 1.6.8
// Задача 2.3.9
// Задача 4.1.1
// Задача 4.2.3
// Задача 5.1.6
// Задача 6.1.4
// Задача 7.3.4
// Задача 7.3.5
public class Student implements Comparable<Student> {
    @Getter
    private String name;
    @Getter
    private LinkedList<Integer> marks;
    private final Rule rule;
//    private static final int MIN_GRADE = 2;
//    private static final int MAX_GRADE = 5;
    private final LinkedList<Action> undoOperations = new LinkedList<>();

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

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Имя не установлено");
        final String tmp = this.name;
        undoOperations.add(() -> this.name = tmp);
        this.name = name;
    }

    public void addMarks(int...marks) {
        int tmp = marks.length;
        undoOperations.add(() -> {
            for (int i = 0; i < tmp; i++) {
                this.marks.removeLast();
            }
        });
        for (int i = 0; i < marks.length; i++) {
            this.setMarksIndex(this.marks.size(), marks[i]);
        }
    }
    public void setMarks(int...marks) {
        if (marks.length > 0) this.marks = new LinkedList<>();
        addMarks(marks);
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

    public void deleteMark(int index) {
        marks.remove(index);
    }
    public void deleteMark() {
        deleteMark(marks.size() - 1);
    }

    @Override
    public String toString() {
        return "Студент \"" + name + "\" с оценками: " + marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return this.name.equals(student.name) && this.averageMarks() == student.averageMarks();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, averageMarks());
    }

    @Override
    public int compareTo(Student student) {
       if (this.averageMarks() > student.averageMarks()) return 1;
       if (this.averageMarks() < student.averageMarks()) return -1;
       return 0;
    }

    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    public void undo() {
        undoOperations.removeLast().act();
    }

    public Student getSave(SaveStudent saveStudent) {
        return saveStudent.getSave();
    }
}