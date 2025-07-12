package studyMFTI;

// Задача 1.5.1
public class Gun {
    private int count = 5;

    public Gun() {}
    public Gun(int count) {
        this.count = count;
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
