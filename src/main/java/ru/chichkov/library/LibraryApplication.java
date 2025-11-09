package ru.chichkov.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.chichkov.library.config.ConfigLibrary;
import ru.chichkov.library.repository.AuthorRepo;
import ru.chichkov.library.repository.BookRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//   Простое консольное приложение "библиотека", которое позволяет:
//      1) вывести на экран все книги (по 5 за раз)
//      2) вывести на экран все книги по автору
//      3) вывести список авторов
//      4) добавить книгу
//      5) добавить автора
//      6) удалить книгу
//      7) удалить автора.
//   Данные хранятся в БД, доступ к ним через Spring Data JPA.
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.chichkov.library.repository")
public class LibraryApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryApplication.class);
        ConfigLibrary library = context.getBean(ConfigLibrary.class);
        BookRepo bookRepo = context.getBean(BookRepo.class);
        AuthorRepo authorRepo = context.getBean(AuthorRepo.class);
        library.start(bookRepo, authorRepo);
    }
}
