package com.library.lms.service.impl;

import com.library.lms.model.IssuedBook;
import com.library.lms.repository.IssuedBookRepository;
import com.library.lms.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Override
    public IssuedBook issueBook(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

    @Override
    public IssuedBook getIssuedBookById(UUID id) {
        return issuedBookRepository.findById(id).orElseThrow(() -> new RuntimeException("Issued book not found"));
    }

    @Override
    public List<IssuedBook> getAllIssuedBooks() {
        return issuedBookRepository.findAll();
    }

    @Override
    public void returnBook(UUID id, IssuedBook issuedBook) {
        IssuedBook existingIssuedBook = getIssuedBookById(id);
        existingIssuedBook.setReturnDate(issuedBook.getReturnDate());
        existingIssuedBook.setFine(issuedBook.getFine());
        issuedBookRepository.save(existingIssuedBook);
    }

    @Override
    public void deleteIssuedBook(UUID id) {
        issuedBookRepository.deleteById(id);
    }
}
