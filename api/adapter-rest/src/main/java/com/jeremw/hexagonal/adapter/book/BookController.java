package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@RestController
@RequestMapping("/books")
public interface BookController {

    @GetMapping
    ResponseEntity<List<Book>> getBooks();

    @GetMapping("/{bookId}")
    ResponseEntity<Book> getBookById(@PathVariable Long bookId);

    @GetMapping("/title/{title}")
    ResponseEntity<Book> getBookByTitle(@PathVariable String title);

    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody Book book);

    @PutMapping("/{bookId}")
    ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book);

    @DeleteMapping("/{bookId}")
    ResponseEntity<Void> deleteBookById(@PathVariable Long bookId);

}
