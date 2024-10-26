package com.jeremw.hexagonal.ports.output;

import com.jeremw.hexagonal.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByTitle(String title);

    Book save(Book book);

    void delete(Book book);
}
