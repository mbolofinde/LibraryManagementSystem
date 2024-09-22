package com.library.lms.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Column(length = 2000)
    private String bio;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    // Constructors, getters, and setters
    public Author() {}

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
