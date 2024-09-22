package com.library.lms.controller;

import com.library.lms.model.IssuedBook;
import com.library.lms.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/issued-books")
public class IssuedBookController {

    @Autowired
    private IssuedBookService issuedBookService;

    @PostMapping
    public ResponseEntity<IssuedBook> issueBook(@RequestBody IssuedBook issuedBook) {
        return new ResponseEntity<>(issuedBookService.issueBook(issuedBook), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssuedBook> getIssuedBookById(@PathVariable UUID id) {
        return new ResponseEntity<>(issuedBookService.getIssuedBookById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<IssuedBook>> getAllIssuedBooks() {
        return new ResponseEntity<>(issuedBookService.getAllIssuedBooks(), HttpStatus.OK);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Void> returnBook(@PathVariable UUID id, @RequestBody IssuedBook issuedBook) {
        issuedBookService.returnBook(id, issuedBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssuedBook(@PathVariable UUID id) {
        issuedBookService.deleteIssuedBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
