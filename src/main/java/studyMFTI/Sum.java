package studyMFTI;

// Задача 2.3.1
public class Sum {

    public static double sum(Number... numbers) {
        double res = 0.0;
        for (Number num : numbers) {
            if (num == null) continue;
            res += num.doubleValue();
        }
        return res;
    }
}
