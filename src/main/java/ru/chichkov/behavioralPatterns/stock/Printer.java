package ru.chichkov.behavioralPatterns.stock;

// Задача 7.3.8
public class Printer implements ChangePrice {
    @Override
    public void changePrice(Stock stock, int newPrice) {
        System.out.println("Акция " + stock.getName() + " изменила цену на " + newPrice);
    }
}
