package ru.chichkov.student;

import java.util.function.Predicate;

// Задача 9.2.5
public class RuleRange extends Rule {
    private Predicate<Integer> range;
    private int max;

    public RuleRange(Predicate<Integer> range, int max) {
        this.range = range;
        this.max = max;
    }

    @Override
    public boolean isCheck(int x) {
        return range.test(x);
    }

    @Override
    public int maxMark() {
        return max;
    }
}
