package ru.chichkov.temperature;

import lombok.Getter;

// Задача 7.1.5
public class Temperature {

    private TypeTemperature name;
    @Getter
    private final int minTemp;
    @Getter
    private final int maxTemp;

    public Temperature(String name) {
        if (name.toUpperCase().equals(TypeTemperature.COLD.getName())) this.name = TypeTemperature.COLD;
        if (name.toUpperCase().equals(TypeTemperature.NORMAL.getName())) this.name = TypeTemperature.NORMAL;
        if (name.toUpperCase().equals(TypeTemperature.HOT.getName())) this.name = TypeTemperature.HOT;
        if (this.name == null) throw new IllegalArgumentException("Невозможно создать объект");
        minTemp =  this.name.getMinTemp();
        maxTemp = this.name.getMaxTemp();
    }
}
