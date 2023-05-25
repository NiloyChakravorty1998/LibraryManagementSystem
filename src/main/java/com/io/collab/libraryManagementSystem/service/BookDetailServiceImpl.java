package com.io.collab.libraryManagementSystem.service;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.repo.BookDetailsRepo;
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
        bookRepo.deleteById(id);
        bookRepo.save(book);
        return book;
    }
}
