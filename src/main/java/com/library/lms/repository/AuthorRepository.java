package com.library.lms.repository;

import com.library.lms.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    // Custom query methods (if needed) can be added here
}
