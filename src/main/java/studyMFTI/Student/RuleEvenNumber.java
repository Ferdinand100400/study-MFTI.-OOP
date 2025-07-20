package studyMFTI.Student;

// Задача 2.3.9
public class RuleEvenNumber extends Rule {
    @Override
    public boolean isCheck(int x) {
        return x % 2 == 0;
    }

    @Override
    public int maxMark() {
        return 100;
    }
}
