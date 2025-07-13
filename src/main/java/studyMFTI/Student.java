package studyMFTI;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Задача 1.3.1
// Задача 1.4.7
// Задача 1.5.6
// Задача 1.6.8
@Getter
public class Student {
    private final String name;
    private List<Integer> marks;

    public Student(String name, int...marks) {
        this.name = name;
        this.setMarks(marks);
    }

    @Override
    public String toString() {
        if (marks == null) return name + ": []";
        String res = name + ": [";
        for (int i = 0; i < marks.size() - 1; i++) {
            res += marks.get(i) + ",";
        }
        res += marks.get(marks.size() - 1) + "]";
        return res;
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
        if (mark < 2 || mark > 5) throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
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
        return ((int) this.averageMarks() == 5);
    }
}