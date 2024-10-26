package com.jeremw.hexagonal;

import com.github.javafaker.Faker;
import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.ports.input.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * This class is responsible for loading initial data into the application when it starts.
 * It implements {@link CommandLineRunner} to execute code after the application context is loaded.
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Slf4j
@Configuration
public class DataLoader implements CommandLineRunner {

    private final BookService bookService;
    private final Faker faker;

    /**
     * Constructs a new DataLoader with the specified BookService.
     *
     * @param bookService the BookService to be used for creating book entries
     */
    public DataLoader(BookService bookService) {
        this.bookService = bookService;
        this.faker = new Faker();
    }

    /**
     * Executes the data loading process upon application startup.
     *
     * <p>
     * This method is called by the Spring framework after the application context
     * is initialized. It starts the process of loading books by calling
     * {@link #loadBooks()}.
     * </p>
     *
     * @param args command-line arguments passed during application startup
     * @throws Exception if any error occurs during the data loading process
     */
    @Override
    public void run(String... args) throws Exception {

        log.info("Loading data...");
        loadBooks();
        log.info("Loading data complete.");
    }

    /**
     * Loads a specified number of fake book entries into the database.
     */
    private void loadBooks() {
        log.info("Loading books...");

        int nbOfBooksToLoad = 30;

        for (int i = 0; i < nbOfBooksToLoad; i++) {
            Book book = Book.builder()
                    .title(faker.book().title())
                    .author(faker.book().author())
                    .build();

            Book bookCreated = bookService.createBook(book);
            log.debug("Book created: {}", bookCreated);
        }

        log.info("Loaded {} books.", nbOfBooksToLoad);

    }
}
