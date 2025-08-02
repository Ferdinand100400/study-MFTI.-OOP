package ru.chichkov.student;

// Задача 4.2.3
public class Rule0To10 extends Rule {
    @Override
    public boolean isCheck(int x) {
        return x >= 0 && x <= 10;
    }

    @Override
    public int maxMark() {
        return 10;
    }
}
