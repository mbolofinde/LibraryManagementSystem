package com.library.lms.service;

import com.library.lms.model.IssuedBook;
import java.util.List;
import java.util.UUID;

public interface IssuedBookService {
    IssuedBook issueBook(IssuedBook issuedBook);
    IssuedBook getIssuedBookById(UUID id);
    List<IssuedBook> getAllIssuedBooks();
    void returnBook(UUID id, IssuedBook issuedBook);
    void deleteIssuedBook(UUID id);
}