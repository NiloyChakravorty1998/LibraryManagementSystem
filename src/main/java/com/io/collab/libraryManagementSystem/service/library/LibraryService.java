package com.io.collab.libraryManagementSystem.service.library;

import com.io.collab.libraryManagementSystem.model.BookDetails;

public interface LibraryService {
    void addBookForUser(Long userId, BookDetails bookDetails);
    String removeBookForUser(Long userId, Long bookId);
}
