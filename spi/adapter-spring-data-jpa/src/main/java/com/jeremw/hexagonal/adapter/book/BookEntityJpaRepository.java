package com.jeremw.hexagonal.adapter.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Repository
public interface BookEntityJpaRepository  extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitle(String title);
}
