package ru.chichkov.library.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Author author;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public Book() {}

    @Override
    public String toString() {
        return "Книга: " +
                "id = " + id +
                ", Название = " + name + '\'' +
                ", " + author;
    }
}
