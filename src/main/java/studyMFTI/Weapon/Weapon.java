package studyMFTI.Weapon;

import lombok.Getter;

// Задача 2.2.1
public abstract class Weapon {
    @Getter
    private int count;

    public Weapon(int count) {
        this.setCount(count);
    }

    public int setCount(int count) {
        if (count < 0) throw new IllegalArgumentException("Отрицательного кол-ва патронов не может быть!");
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
    public abstract void shoot();
}
