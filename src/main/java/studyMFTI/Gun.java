package studyMFTI;

import lombok.Getter;

// Задача 1.5.1
// Задача 1.6.5
@Getter
public class Gun {
    private int count;
    private final int maxCount;

    public Gun(int maxCount, int count) {
        this.maxCount = maxCount;
        this.setCount(count);
    }
    public Gun(int maxCount) {
        this(maxCount, 5);
    }

    public int setCount(int count) {
        if (count < 0) throw new IllegalArgumentException("Отрицательного кол-ва патронов не может быть!");
        if (count > maxCount) {
            count = this.count;
            this.count = maxCount;
            return count - maxCount;
        }
        this.count = count;
        return 0;
    }

    public int discharge() {
        int count = this.count;
        this.count = 0;
        return count;
    }

    public boolean isCharge() {
        return count != 0;
    }

    public void shoot() {
        if (count > 0) {
            System.out.println("Бах!");
            count--;
            return;
        }
        System.out.println("Клац!");
    }
}
