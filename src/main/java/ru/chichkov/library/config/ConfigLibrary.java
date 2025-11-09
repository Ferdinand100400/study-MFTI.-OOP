package ru.chichkov.library.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.chichkov.human.Name;
import ru.chichkov.library.entity.Author;
import ru.chichkov.library.entity.Book;
import ru.chichkov.library.repository.AuthorRepo;
import ru.chichkov.library.repository.BookRepo;

import java.util.List;
import java.util.Scanner;

@Configuration
public class ConfigLibrary {
    @Bean
    public CommandLineRunner start(BookRepo bookRepo, AuthorRepo authorRepo) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nМеню библиотеки:");
                System.out.println("1. вывести на экран все книги (по 5 за раз)");
                System.out.println("2. вывести на экран все книги по автору");
                System.out.println("3. вывести список авторов");
                System.out.println("4. добавить книгу");
                System.out.println("5. добавить автора");
                System.out.println("6. удалить книгу");
                System.out.println("7. удалить автора");
                System.out.println("0. выход");
                System.out.print("Введите операцию: ");

                String operation = scanner.nextLine();

                switch (operation) {
                    case "1":
                        listAllBooks(bookRepo, scanner);
                        break;
                    case "2":
                        listBooksByAuthor(bookRepo, authorRepo, scanner);
                        break;
                    case "3":
                        listAllAuthors(authorRepo);
                        break;
                    case "4":
                        addBook(bookRepo, authorRepo, scanner);
                        break;
                    case "5":
                        addAuthor(authorRepo, scanner);
                        break;
                    case "6":
                        deleteBook(bookRepo, scanner);
                        break;
                    case "7":
                        deleteAuthor(authorRepo, scanner);
                        break;
                    case "0":
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверная операция повотрите ввод!");
                        break;
                }
            }
        };
    }

    private void listAllBooks(BookRepo bookRepo, Scanner scanner) {
        int pageNumber = 0;
        int pageSize = 5;

        while (true) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<Book> page = bookRepo.findAll(pageable);
            List<Book> books = page.getContent();

            if (books.isEmpty()) {
                System.out.println("Книги не найдены");
                break;
            }

            books.forEach(System.out::println);

            if (page.hasNext()) {
                System.out.print("Нажмите 'Enter', чтобы продолжить или 'q', чтобы выйти: ");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    break;
                }
                pageNumber++;
            } else {
                System.out.println("Больше книг нет!");
                break;
            }
        }
    }

    private void listBooksByAuthor(BookRepo bookRepo, AuthorRepo authorRepo, Scanner scanner) {
        System.out.print("Введите автора, в формате: фамилия имя отчество");
        List<String> authorName = List.of(scanner.nextLine().split(" "));
        if (!isTrueFormatName(authorName)) return;
        Name authorFullName = createName(authorName);
        Author author = authorRepo.findByName(authorFullName);
        if (author == null) {
            System.out.println("Такого автора нет!");
            return;
        }
        List<Book> books = bookRepo.findByAuthor(author);
        if (books.isEmpty())
            System.out.println("Книг с автором: " + author + " нет!");
        else
            books.forEach(System.out::println);

    }

    private void listAllAuthors(AuthorRepo authorRepo) {
        List<Author> authors = authorRepo.findAll();
        if (authors.isEmpty()) {
            System.out.println("Нет авторов");
            return;
        }
        authors.forEach(System.out::println);
    }

    private void addBook(BookRepo bookRepo, AuthorRepo authorRepo, Scanner scanner) {
        System.out.print("Введите название книги: ");
        String nameBook = scanner.nextLine();
        if (bookRepo.findByName(nameBook) != null) {
            System.out.println("Книга '" + nameBook + "' уже есть!");
            return;
        }
        System.out.println("Введите автора, в формате: фамилия имя отчество ");
        List<String> authorName = List.of(scanner.nextLine().split(" "));
        if (!isTrueFormatName(authorName)) return;
        Name authorFullName = createName(authorName);
        Author author = authorRepo.findByName(authorFullName);
        if (author == null) {
            System.out.println("Автора в базе нет, добавляем в базу...");
            author = new Author(authorFullName);
            authorRepo.save(author);
        }
        bookRepo.save(new Book(nameBook, author));
        System.out.println("Книга успешно добавлена!");
    }

    private void addAuthor(AuthorRepo authorRepo, Scanner scanner) {
        System.out.println("Введите автора, в формате: фамилия имя отчество ");
        List<String> authorName = List.of(scanner.nextLine().split(" "));
        if (!isTrueFormatName(authorName)) return;
        Name authorFullName = createName(authorName);
        Author author = authorRepo.findByName(authorFullName);
        if (author != null) {
            System.out.println("Автор уже есть в базе!");
            return;
        }
        authorRepo.save(new Author(authorFullName));
        System.out.println("Автор успешно добавлен!");
    }


    private void deleteBook(BookRepo bookRepo, Scanner scanner) {
        System.out.print("Введите название книги: ");
        String nameBook = scanner.nextLine();
        if (bookRepo.findByName(nameBook) == null) {
            System.out.println("Книга '" + nameBook + "' не найдена!");
            return;
        }
        bookRepo.deleteByName(nameBook);
        System.out.println("Книга успешно удалена!");
    }


    private void deleteAuthor(AuthorRepo authorRepo, Scanner scanner) {
        System.out.println("Введите автора, в формате: Фамилия Имя Отчество");
        List<String> authorName = List.of(scanner.nextLine().split(" "));
        if (!isTrueFormatName(authorName)) return;
        Name authorFullName = createName(authorName);
        if (authorRepo.findByName(authorFullName) == null) {
            System.out.println("Автор не найден!");
            return;
        }
        authorRepo.deleteByName(authorFullName);
        System.out.println("Автор успешно удален!");
    }

    private Name createName(List<String> fullName) {
        return Name.builder()
                .surname(fullName.get(0))
                .firstName(fullName.size() > 1 ? fullName.get(1) : "")
                .patronymic(fullName.size() > 2 ? fullName.get(2) : "")
                .build();
    }

    private boolean isTrueFormatName(List<String> authorName) {
        if (authorName.size() > 3 || (authorName.size() == 1 && authorName.get(0).equals(""))) {
            System.out.println("Неверный формат");
            return false;
        }
        return true;
    }
}

