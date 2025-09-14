package ru.chichkov.behavioralPatterns.stock;

// Задача 7.3.8
public class Bot implements ChangePrice {
    @Override
    public void changePrice(Stock stock, int newPrice) {
        if (stock.getName().equals("ORCL") && newPrice < 70) {
            System.out.println("Надо покупать ORCL");
        }
    }
}