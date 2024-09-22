package com.library.lms.service;

import com.library.lms.model.Author;
import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(UUID id);
    List<Author> getAllAuthors();
    Author updateAuthor(UUID id, Author author);
    void deleteAuthor(UUID id);
}
