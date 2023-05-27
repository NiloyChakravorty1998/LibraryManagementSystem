package com.io.collab.libraryManagementSystem.repo;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailsRepo extends JpaRepository<BookDetails, Long> {
    List<BookDetails> getBookDetailsByAuthor(String author, Pageable page);
    List<BookDetails> getBookDetailsByGenre(String genre, Pageable page);
}
