package studyMFTI.Weapon;

import lombok.Getter;

// Задача 1.5.1
// Задача 1.6.5
// Задача 2.2.1
@Getter
public class Gun extends Weapon {
    private final int maxCount;

    public Gun(int maxCount, int count) {
        super(count);
        if (maxCount < 0)
            throw new IllegalArgumentException("Отрицательного максимальное кол-ва патронов не может быть!");
        this.maxCount = maxCount;
        this.setCount(count);
    }

    public Gun(int maxCount) {
        this(maxCount, 5);
    }

    @Override
    public int setCount(int count) {
        if (count > maxCount) {
//            count = super.getCount();
//            super.setCount(maxCount);
            return count - super.setCount(maxCount);
        }
        return super.setCount(count);
    }

    @Override
    public void shoot() {
        if (super.getCount() > 0) {
            System.out.println("Бах!");
            super.setCount(super.getCount() - 1);
            return;
        }
        System.out.println("Клац!");
    }
}
