package studyMFTI;

// Задача 2.3.5
public interface InterfaceLength {
    int length();

    static int generalLength(InterfaceLength... objectsLengths) {
        int res = 0;
        for (InterfaceLength objects: objectsLengths) {
            res += objects.length();
        }
        return res;
    }
}
