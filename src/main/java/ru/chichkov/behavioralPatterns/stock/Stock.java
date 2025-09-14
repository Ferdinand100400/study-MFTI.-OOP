package ru.chichkov.behavioralPatterns.stock;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Задача 7.3.8
public class Stock {
   @Getter
    private final String name;
    private int price;
    private final List<ChangePrice> listChanging = new ArrayList<>();

    private Stock(String name, int price) {
        this.name = name;
        setPrice(price);
    }
    public static Stock of(String name, int price) {
        return new Stock(name, price);
    }
    public void setPrice(int price) {
        if (this.price == price) return;
        this.price = price;
        notifyListeners();
    }
    public void addListener(ChangePrice changePrice) {
        listChanging.add(changePrice);
    }

    public void removeListener(ChangePrice changePrice) {
        listChanging.remove(changePrice);
    }

    private void notifyListeners() {
        for (ChangePrice list : listChanging) {
            list.changePrice(this, price);
        }
    }
}
