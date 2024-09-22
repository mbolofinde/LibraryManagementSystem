# LibraryManagementSystem
## Context and Overview: The goal is to develop a Library Management System (LMS) using Java with Spring Boot 3 as the framework, Gradle as the build tool, and JDK 17. The LMS should support basic CRUD operations, advanced search, book issuing, serialization, and deserialization functionalities.

## Using Spring Boot will allow us to efficiently manage dependency injection, create RESTful APIs, and handle various other backend tasks seamlessly.

## Technology Stack:
Programming Language: Java (JDK 17)
Framework: Spring Boot 3
Build Tool: Gradle
Persistence: Spring Data JPA with H2 (initially) and later expandable to MySQL/PostgreSQL.
Serialization Format: JSON (using Jackson) / XML
Testing: JUnit 5, Spring Boot Test
Logging: SLF4J with Logback
REST API Documentation: SpringDoc OpenAPI 3 (Swagger UI)
Security: Spring Security (for authentication and authorization)

## High-Level Requirements:
Core Functionalities:

CRUD Operations:

Books: Create, Read, Update, Delete.
Members: Create, Read, Update, Delete.
Authors: Create, Read, Update, Delete.
Advanced Search:

Implement using Spring Data JPA’s query methods.
Search by title, author, publication date, genre, etc.
Fuzzy search capabilities.
Book Issuing and Return:

Issue books to members.
Track issued books and their return status.
Calculate fines based on overdue days.
Serialization & Deserialization:

Ability to save and load the library's state (books, members, issued books) using serialization.
Implemented using JSON and XML.
Additional Requirements:

Security: Implement using Spring Security.
Basic authentication for admin tasks.
Role-based access control for members and admins.
Report Generation: Generate reports using Spring Boot's scheduling and reporting capabilities.
REST API: Expose endpoints for all functionalities, documented using SpringDoc OpenAPI (Swagger).
User Interface: Optionally, we can add a front-end later using Angular/React.

## Use Cases:
Admin Use Cases:

Add a new book to the library.
Remove a book from the library.
Update book details.
Register a new member.
Issue a book to a member.
Generate reports via REST API.
Member Use Cases:

Search for a book.
View borrowed books and their due dates.
Return a book.
Pay overdue fines via REST API.
System Use Cases:

Automatically calculate fines for overdue books.
Serialize the library's state to a file via REST endpoint.
Deserialize the library's state from a file via REST endpoint.
Notify members about overdue books (future enhancement via scheduled tasks).

## Entity Identification:
As mentioned before, with the addition of Spring Boot, the entities will now be managed via Spring Data JPA. Here are the core entities:

Book:

Attributes: ISBN, title, author(s), genre, publication date, availability status, etc.
Relationships: Linked to one or more authors.
Member:

Attributes: Member ID, name, email, phone number, membership date, etc.
Relationships: Linked to borrowed books.
Author:

Attributes: Author ID, name, bio, list of books authored.
Librarian/Admin:

Attributes: Admin ID, name, role, etc.
IssuedBook (Transaction entity):

Attributes: Issue ID, book, member, issue date, due date, return date, fine.
Relationships: Linked to a specific book and a specific member.

## Detailed Design Specification:
Domain Model: Using JPA annotations, we’ll define entities such as Book, Member, Author, and IssuedBook.

Service Layer: Spring Boot services will manage the business logic, for example, issuing a book will update both the Book and IssuedBook entities.

Repository Layer: Spring Data JPA will be used to interact with the database.

Controller Layer: Expose RESTful endpoints via Spring MVC, documented with SpringDoc OpenAPI.

Serialization/Deserialization: Implement endpoints to save/load the library’s state.

Security Configuration: Configure Spring Security for role-based access control.

Exception Handling: Global exception handling using @ControllerAdvice.