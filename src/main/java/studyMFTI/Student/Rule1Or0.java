package studyMFTI.Student;

// Задача 2.3.9
public class Rule1Or0 extends Rule {
    @Override
    public boolean isCheck(int x) {
        return x == 0 || x == 1;
    }

    @Override
    public int maxMark() {
        return 1;
    }
}
