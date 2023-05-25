package com.io.collab.libraryManagementSystem.service;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.repo.BookDetailsRepo;

import java.util.List;

public interface BookDetailsService {
    void saveBook(BookDetails bookDetails);
    BookDetails getBookById(Long id);
    List<BookDetails> getAllBooks();
    void deleteBookById(Long id);
    BookDetails updateBookById(BookDetails bookDetails, Long id);

}
