package studyMFTI.MeowAnimals;

// Задача 2.3.4
public interface MeowAnimals {
    void meow();

    // Задача 2.3.4
    static void meow(MeowAnimals... meowAnimals) {
        for (MeowAnimals animal: meowAnimals) {
            animal.meow();
        }
    }
}
