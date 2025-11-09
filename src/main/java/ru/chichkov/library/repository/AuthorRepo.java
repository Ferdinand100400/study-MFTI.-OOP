package ru.chichkov.library.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.chichkov.human.Name;
import ru.chichkov.library.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepo extends ListPagingAndSortingRepository<Author, Long>, ListCrudRepository<Author, Long> {
    Author findByName(Name name);
    void deleteByName(Name name);
}
