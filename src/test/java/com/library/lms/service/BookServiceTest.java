package com.library.lms.service;

import com.library.lms.model.Book;
import com.library.lms.model.Genre;
import com.library.lms.repository.BookRepository;
import com.library.lms.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book("123456789", "Test Book", Genre.FICTION, new Date(), 10);
    }

    @Test
    void createBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.createBook(book);
        assertNotNull(savedBook);
        assertEquals(book.getTitle(), savedBook.getTitle());
    }

    @Test
    void getBookById() {
        UUID bookId = UUID.randomUUID();
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        Book foundBook = bookService.getBookById(bookId);
        assertNotNull(foundBook);
        assertEquals(book.getTitle(), foundBook.getTitle());
    }

    @Test
    void deleteBook() {
        UUID bookId = UUID.randomUUID();
        doNothing().when(bookRepository).deleteById(bookId);
        assertDoesNotThrow(() -> bookService.deleteBook(bookId));
        verify(bookRepository, times(1)).deleteById(bookId);
    }
}
