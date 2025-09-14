package ru.chichkov.behavioralPatterns;

import ru.chichkov.student.Student;

public class SaveStudentImpl implements SaveStudent {
    private final Student saveStudent;

    public SaveStudentImpl(Student saveStudent) {
        this.saveStudent = saveStudent;
    }

    @Override
    public Student getSave() {
        return saveStudent;
    }
}
