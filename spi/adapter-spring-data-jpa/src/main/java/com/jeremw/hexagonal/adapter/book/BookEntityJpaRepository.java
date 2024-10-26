package com.jeremw.hexagonal.adapter.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and managing {@link BookEntity} instances.
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Repository
public interface BookEntityJpaRepository extends JpaRepository<BookEntity, Long> {

    /**
     * Finds a {@link BookEntity} by its title.
     *
     * @param title the title of the book to search for
     * @return an {@link Optional} containing the found {@link BookEntity},
     * or an empty {@link Optional} if no book with the given title exists
     */
    Optional<BookEntity> findByTitle(String title);
}
