package com.io.collab.libraryManagementSystem.service.book;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.model.UserDetails;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDetailsService {
    void saveBook(BookDetails bookDetails);
    BookDetails getBookById(Long id);
    List<BookDetails> getAllBooks();
    void deleteBookById(Long id);
    BookDetails updateBookById(BookDetails bookDetails, Long id);
    List<BookDetails> getBooksByGenre(String genre, Pageable page);
    List<BookDetails> getBooksByAuthor(String author,Pageable page);


}
