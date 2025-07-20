package studyMFTI.Bird;

import java.util.Random;

// Задача 2.2.3
public class Cuckoo extends Bird {
  //  private final Random random = new Random();
    @Override
    public void sing() {
        Random random = new Random();
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}
