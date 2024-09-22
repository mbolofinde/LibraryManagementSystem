package com.library.lms.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date membershipDate;

    @OneToMany(mappedBy = "member")
    private Set<IssuedBook> borrowedBooks;

    // Constructors, getters, and setters
    public Member() {}

    public Member(String name, String email, String phone, Date membershipDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipDate = membershipDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public Set<IssuedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Set<IssuedBook> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
