package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.ports.output.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Component
public class BookRepositoryImpl implements BookRepository {

    private final BookEntityJpaRepository bookEntityJpaRepository;

    public BookRepositoryImpl(BookEntityJpaRepository bookEntityJpaRepository) {
        this.bookEntityJpaRepository = bookEntityJpaRepository;
    }

    @Override
    public List<Book> findAll() {
        return BookMapper.INSTANCE.toModelList(bookEntityJpaRepository.findAll());
    }

    @Override
    public Optional<Book> findById(Long id) {

        return Optional.of(BookMapper.INSTANCE.toModel(bookEntityJpaRepository.findById(id).get()));
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return Optional.of(BookMapper.INSTANCE.toModel(bookEntityJpaRepository.findByTitle(title).get()));
    }

    @Override
    public Book save(Book book) {

        BookEntity bookEntity = BookMapper.INSTANCE.toEntity(book);
        return BookMapper.INSTANCE.toModel(bookEntityJpaRepository.save(bookEntity));
    }

    @Override
    public void delete(Book book) {
        bookEntityJpaRepository.delete(BookMapper.INSTANCE.toEntity(book));
    }
}
