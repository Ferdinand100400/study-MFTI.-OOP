package ru.chichkov.temperature;

// Задача 7.1.5
public class Temperature {

    private final String name;
    private int minTemp;
    private int maxTemp;

    public Temperature(String name, int currentTemp) {
        if (name.equals("Холодно")) setMinAndMaxTemp(-50, 10);
        if (name.equals("Нормально")) setMinAndMaxTemp(10, 25);
        if (name.equals("Жарко")) setMinAndMaxTemp(25, 60);
        if (!(currentTemp > minTemp && currentTemp < maxTemp)) throw new IllegalArgumentException("Невозможно создать объект");
        this.name = name;
    }

    private void setMinAndMaxTemp(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
}
