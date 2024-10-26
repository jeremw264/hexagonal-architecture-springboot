package com.jeremw.hexagonal.service;

import com.jeremw.hexagonal.domain.Book;
import com.jeremw.hexagonal.exception.BookNotFound;
import com.jeremw.hexagonal.ports.output.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book(1L, "Test Book", "Test Author");
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = List.of(book);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertEquals(books, result);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testGetBookById_Success() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1L);

        assertEquals(book, result);
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetBookById_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(BookNotFound.class, () -> {
            bookService.getBookById(1L);
        });

        assertEquals("Book not found with id: 1", exception.getMessage());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetBookByTitle_Success() {
        when(bookRepository.findByTitle("Test Book")).thenReturn(Optional.of(book));

        Book result = bookService.getBookByTitle("Test Book");

        assertEquals(book, result);
        verify(bookRepository, times(1)).findByTitle("Test Book");
    }

    @Test
    public void testGetBookByTitle_NotFound() {
        when(bookRepository.findByTitle("Nonexistent Title")).thenReturn(Optional.empty());

        Exception exception = assertThrows(BookNotFound.class, () -> {
            bookService.getBookByTitle("Nonexistent Title");
        });

        assertEquals("Book not found with the title: Nonexistent Title", exception.getMessage());
        verify(bookRepository, times(1)).findByTitle("Nonexistent Title");
    }

    @Test
    public void testCreateBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book result = bookService.createBook(book);

        assertEquals(book, result);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdateBook_Success() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book updatedBook = new Book(0, "Updated Title", null);
        Book result = bookService.updateBook(1L, updatedBook);

        assertEquals("Updated Title", result.getTitle());
        assertEquals("Test Author", result.getAuthor());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdateBook_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(BookNotFound.class, () -> {
            bookService.updateBook(1L, book);
        });

        assertEquals("Book not found with id: 1", exception.getMessage());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteBookById_Success() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        assertDoesNotThrow(() -> {
            bookService.deleteBookById(1L);
        });

        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    public void testDeleteBookById_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(BookNotFound.class, () -> {
            bookService.deleteBookById(1L);
        });

        assertEquals("Book not found with id: 1", exception.getMessage());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(0)).delete(any(Book.class));
    }
}
