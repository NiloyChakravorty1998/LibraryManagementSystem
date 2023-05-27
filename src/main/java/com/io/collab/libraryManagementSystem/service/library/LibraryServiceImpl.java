package com.io.collab.libraryManagementSystem.service.library;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.model.UserDetails;
import com.io.collab.libraryManagementSystem.repo.BookDetailsRepo;
import com.io.collab.libraryManagementSystem.repo.UserDetailsRepo;

import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    private BookDetailsRepo bookRepo;
    private UserDetailsRepo userRepo;

    public LibraryServiceImpl(BookDetailsRepo bookRepo, UserDetailsRepo userRepo)  {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }


    @Override
    public void addBookForUser(Long userId, BookDetails bookDetails) {
        UserDetails userDetails = userRepo.getReferenceById(userId);
        bookDetails.setUserDetails(userDetails);
        bookDetails.setIsAvailable("Issued");
        userDetails.getListOfBooks().add(bookDetails);
        userDetails.setNumberOfBooks(userDetails.getNumberOfBooks() + 1);
        userRepo.save(userDetails);
    }

    @Override
    public String removeBookForUser(Long userId, Long bookId) {
        UserDetails userDetails = userRepo.getReferenceById(userId);
        String notFoundMessage = "<html><body><h1> Book not found with the user</h1></body></html>";

        BookDetails bookToRemove = userDetails.getListOfBooks().stream()
                .filter(book -> book.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);

        if (bookToRemove == null) {
            return notFoundMessage;
        }
        bookToRemove.setIsAvailable("Available");
        bookToRemove.setUserDetails(null);
        bookRepo.save(bookToRemove);
        userDetails.getListOfBooks().remove(bookToRemove);
        userDetails.setNumberOfBooks(userDetails.getNumberOfBooks() - 1);
        userRepo.save(userDetails);

        return "<html><body><h1> Book removed successfully from the user</h1></body></html>";
    }

}
