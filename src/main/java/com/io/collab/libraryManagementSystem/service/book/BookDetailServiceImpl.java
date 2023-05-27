package com.io.collab.libraryManagementSystem.service.book;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.model.UserDetails;
import com.io.collab.libraryManagementSystem.repo.BookDetailsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailServiceImpl implements BookDetailsService {

    private BookDetailsRepo bookRepo;

    public BookDetailServiceImpl(BookDetailsRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void saveBook(BookDetails bookDetails) {
        bookRepo.save(bookDetails);
    }

    @Override
    public BookDetails getBookById(Long id) {
        return bookRepo.getReferenceById(id);
    }

    @Override
    public List<BookDetails> getAllBooks() {
        return  bookRepo.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public BookDetails updateBookById(BookDetails bookDetails, Long id) {
        BookDetails book = new BookDetails();
        book.setBookId(id);
        book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        book.setBookDescription(bookDetails.getBookDescription());
        book.setIsAvailable(bookDetails.getIsAvailable());
        bookRepo.save(book);
        return book;
    }

    @Override
    public List<BookDetails> getBooksByGenre(String genre, Pageable page) {
        return bookRepo.getBookDetailsByGenre(genre, page);
    }

    @Override
    public List<BookDetails> getBooksByAuthor(String author, Pageable page) {
        return bookRepo.getBookDetailsByAuthor(author,page);
    }

}
