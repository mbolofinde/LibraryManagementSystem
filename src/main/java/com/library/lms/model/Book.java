package com.library.lms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Book {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String isbn;
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    private int availableCopies;
    private int totalCopies;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    @OneToMany(mappedBy = "book")
    private Set<IssuedBook> issuedBooks;

    // Constructors, getters, and setters
    public Book() {}

    public Book(String isbn, String title, Genre genre, Date publicationDate, int totalCopies) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

}
