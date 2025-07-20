package studyMFTI.Bird;

import lombok.AllArgsConstructor;

import java.util.Random;

// Задача 2.2.3
@AllArgsConstructor
public class Parrot extends Bird {
    private final String text;

    @Override
    public void sing() {
        Random random = new Random();
        int count = random.nextInt(text.length() - 1) + 1;
        System.out.println(text.substring(0, count));
    }
}
