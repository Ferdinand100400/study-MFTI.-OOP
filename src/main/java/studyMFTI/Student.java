package studyMFTI;

import java.util.ArrayList;
import java.util.List;

// Задача 1.3.1
// Задача 1.4.7
public class Student {
    private String name;
    private List<Integer> marks;

    public Student(String name, int...marks) {
        this.name = name;
        if (marks.length > 0) this.marks = new ArrayList<>();
        for (int mark : marks) {
            this.marks.add(mark);
        }
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

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
    public void setMarksIndex(int marks, int index) {
        this.marks.set(index, marks);
    }
}
