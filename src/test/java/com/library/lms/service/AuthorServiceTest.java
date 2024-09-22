package com.library.lms.service;

import com.library.lms.model.Author;
import com.library.lms.repository.AuthorRepository;
import com.library.lms.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    private Author author;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        author = new Author("John Doe", "A famous author");
    }

    @Test
    void createAuthor() {
        when(authorRepository.save(any(Author.class))).thenReturn(author);
        Author savedAuthor = authorService.createAuthor(author);
        assertNotNull(savedAuthor);
        assertEquals(author.getName(), savedAuthor.getName());
    }

    @Test
    void getAuthorById() {
        UUID authorId = UUID.randomUUID();
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        Author foundAuthor = authorService.getAuthorById(authorId);
        assertNotNull(foundAuthor);
        assertEquals(author.getName(), foundAuthor.getName());
    }

    @Test
    void deleteAuthor() {
        UUID authorId = UUID.randomUUID();
        doNothing().when(authorRepository).deleteById(authorId);
        assertDoesNotThrow(() -> authorService.deleteAuthor(authorId));
        verify(authorRepository, times(1)).deleteById(authorId);
    }
}
