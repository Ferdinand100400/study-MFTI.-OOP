package studyMFTI;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Задача 1.5.2
@AllArgsConstructor
public class Cat {
    @Getter
    private String name;

    @Override
    public String toString() {
        return "Кот: " + name;
    }

    public void meow(int count) {
        if (count < 1) throw new IllegalArgumentException("Кол-во мяуканий не может быть меньше 1");
        System.out.print(name + ": ");
        for (int i = 0; i < count - 1; i++) {
            System.out.print("мяу-");
        }
        System.out.println("мяу!");
    }

    public void meow() {
        meow(1);
    }
}
