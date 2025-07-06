package studyMFTI;

// Задача 1.1.5
// Задача 1.4.4
public class House {
    public final int amountFloor;

    public House(int amountFloor) {
        this.amountFloor = amountFloor;
    }

    @Override
    public String toString() {
        if (amountFloor < 1) throw new NumberFormatException("Кол-во этажей не может быть меньше 1");
        return "Дом с " + amountFloor + trueEnding();
    }

    public String trueEnding() {
        if (amountFloor % 10 == 1 && amountFloor != 11) {
            return " этажом";
        }
        return " этажами";
    }

}
