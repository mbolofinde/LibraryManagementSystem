package com.library.lms.repository;

import com.library.lms.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, UUID> {
    // Custom query methods (if needed) can be added here
}
