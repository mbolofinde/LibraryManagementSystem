package com.library.lms.service;

import com.library.lms.model.Book;
import java.util.List;
import java.util.UUID;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(UUID id);
    List<Book> getAllBooks();
    Book updateBook(UUID id, Book book);
    void deleteBook(UUID id);
}
