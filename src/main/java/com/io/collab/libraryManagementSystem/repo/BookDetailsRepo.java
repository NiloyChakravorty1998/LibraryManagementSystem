package com.io.collab.libraryManagementSystem.repo;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepo extends JpaRepository<BookDetails, Long> {
}
