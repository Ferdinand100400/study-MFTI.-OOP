package ru.chichkov.temperature;

// Задача 7.1.5
public enum TypeTemperature {
    COLD("ХОЛОДНО", -50, 10),
    NORMAL("НОРМАЛЬНО", 10, 25),
    HOT("ЖАРКО", 25, 60);

    private final String name;
    private final int minTemp;
    private final int maxTemp;

    TypeTemperature(String name, int minTemp, int maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getName() {
        return name;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}
