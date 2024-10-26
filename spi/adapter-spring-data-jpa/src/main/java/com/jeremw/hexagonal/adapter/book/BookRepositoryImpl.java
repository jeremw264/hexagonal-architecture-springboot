package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.ports.output.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link BookRepository} interface.
 * <p>
 * This class provides the concrete implementation for the data access methods defined in the
 * {@link BookRepository} interface. It uses the {@link BookEntityJpaRepository} to perform CRUD
 * operations on the underlying database and converts between the domain model {@link Book}
 * and the data entity {@link BookEntity} using {@link BookMapper}.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Component
public class BookRepositoryImpl implements BookRepository {

    private final BookEntityJpaRepository bookEntityJpaRepository;

    /**
     * Constructs a new {@link BookRepositoryImpl} with the specified
     * {@link BookEntityJpaRepository}.
     *
     * @param bookEntityJpaRepository the JPA repository used for CRUD operations on
     *                                {@link BookEntity}
     */
    public BookRepositoryImpl(BookEntityJpaRepository bookEntityJpaRepository) {
        this.bookEntityJpaRepository = bookEntityJpaRepository;
    }

    @Override
    public List<Book> findAll() {
        return BookMapper.INSTANCE.toModelList(bookEntityJpaRepository.findAll());
    }

    @Override
    public Optional<Book> findById(Long id) {

        return bookEntityJpaRepository.findById(id).map(BookMapper.INSTANCE::toModel);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookEntityJpaRepository.findByTitle(title).map(BookMapper.INSTANCE::toModel);
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
