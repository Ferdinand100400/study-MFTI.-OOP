package ru.chichkov.library.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.chichkov.library.entity.Author;
import ru.chichkov.library.entity.Book;

import java.util.List;

@Repository
public interface BookRepo extends ListPagingAndSortingRepository<Book, Long>, ListCrudRepository<Book, Long> {
    List<Book> findByAuthor(Author author);
    Book findByName(String name);
    void deleteByName(String name);

}
