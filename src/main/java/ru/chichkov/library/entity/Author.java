package ru.chichkov.library.entity;

import jakarta.persistence.*;
import ru.chichkov.human.Name;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name name;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(Name name) {
        this.name = name;
    }

    public Author() {}

    @Override
    public String toString() {
        return "Автор: " +
                "id = " + id +
                ", ФИО = " + name;
    }
}
