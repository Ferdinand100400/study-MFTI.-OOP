package ru.chichkov.student;

// Задача 2.3.9
public class NotRule extends Rule {
    @Override
    public boolean isCheck(int x) {
        return true;
    }

    @Override
    public int maxMark() {
        return 5;
    }
}
