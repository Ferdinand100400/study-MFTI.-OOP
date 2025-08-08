package ru.chichkov.city;

import lombok.Data;

import java.util.Objects;

// Задача 1.3.3
// Задача 1.6.9
// Задача 5.1.5
@Data
public class Way {
    private final City city;
    private Integer price;

    public Way(City city, int price) {
        this.city = city;
        this.price = price;
    }
    @Override
    public String toString() {
        return city.getName() + ": " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Way way)) return false;
        return Objects.equals(this.city.getName(), way.city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.getName());
    }
}
