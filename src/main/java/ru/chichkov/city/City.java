package ru.chichkov.city;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Задача 1.3.3
// Задача 1.4.8
// Задача 1.6.9
// Задача 5.1.5
@Getter
public class City {
    private final String name;
    private List<Way> ways;

    public City(String name, Way... ways) {
        this.name = name;
        this.setWays(ways);
    }

    public City(String name) {
        this(name, (Way) null);
    }

    @Override
    public String toString() {
        if (this.ways.size() == 0) return "";
        String res = name + " {";
        for (int i = 0; i < ways.size() - 1; i++) {
            res += ways.get(i) + ", ";
        }
        res += ways.get(ways.size() - 1) + "}";
        return res;
    }

    public void setWays(Way... ways) {
        if (ways.length > 0) this.ways = new ArrayList<>();
        for (int i = 0; i < ways.length; i++) {
            this.setWay(i, ways[i]);
        }
    }

    public void setWay(int index, Way way) {
        if (way == null) return;
        if (index > this.ways.size()) throw new IllegalArgumentException("Индекс больше количества путей");
        if (index < 0) throw new IllegalArgumentException("Индекс не может быть отрицательным");
        int i = checkWay(way);
        if (i != -1) {
            this.ways.get(i).setPrice(way.getPrice());
            return;
        }
        if (index == this.ways.size()) this.ways.add(way);
        this.ways.set(index, way);
    }

    public void addWay(Way way) {
        this.setWay(this.ways.size(), way);
    }

    public void deleteWay(int index) {
        if (index > this.ways.size() - 1) throw new IllegalArgumentException("Индекс больше количества путей");
        if (index < 0) throw new IllegalArgumentException("Индекс не может быть отрицательным");
        this.ways.remove(index);
    }

    private int checkWay(Way way) {
        for (int i = 0; i < this.ways.size(); i++) {
            if (this.ways.get(i).equals(way)) return i;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        if (this.ways.size() != city.ways.size()) return false;
        for (int i = 0; i < this.ways.size(); i++) {
            if (!equalsWays(city.ways.get(i), i)) return false;
        }
        return true;
    }

    private boolean equalsWays(Way way, int index) {
        for (int i = 0; i < this.ways.size(); i++) {
            if (way.equals(this.ways.get(i))) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashWays = 0;
        for (int i = 0; i < ways.size(); i++) {
            hashWays += ways.get(i).hashCode();
        }
        return Objects.hash(hashWays);
    }
}
