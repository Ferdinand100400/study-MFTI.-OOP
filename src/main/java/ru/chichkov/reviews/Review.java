package ru.chichkov.reviews;


// Задача 9.2.2
public class Review {
    private String textReview;
    private int mark;

    public Review(String textReview, int mark) {
        this.textReview = textReview;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Отзыв: " + textReview +
                " оценка: " + mark;
    }

    public int getMark() {
        return mark;
    }
}
