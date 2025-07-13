package studyMFTI;

// Задача 1.1.5
// Задача 1.4.4
// Задача 1.6.1
public record House(int amountFloor) {
    public House {
        if (amountFloor < 0) throw new IllegalArgumentException("Кол-во этажей не может быть отрицательным");
    }

    @Override
    public String toString() {
        return "Дом с " + amountFloor + trueEnding();
    }

    public String trueEnding() {
        if (amountFloor % 10 == 1 && amountFloor != 11) {
            return " этажом";
        }
        return " этажами";
    }

}
