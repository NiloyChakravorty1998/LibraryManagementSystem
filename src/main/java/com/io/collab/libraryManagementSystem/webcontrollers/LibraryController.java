package com.io.collab.libraryManagementSystem.webcontrollers;

import com.io.collab.libraryManagementSystem.service.book.BookDetailServiceImpl;
import com.io.collab.libraryManagementSystem.service.library.LibraryServiceImpl;
import com.io.collab.libraryManagementSystem.service.user.UserDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private UserDetailServiceImpl userDetailService;
    private LibraryServiceImpl libraryService;
    private BookDetailServiceImpl bookDetailService;

    public LibraryController(UserDetailServiceImpl userDetailService, LibraryServiceImpl libraryService, BookDetailServiceImpl bookDetailService) {
        this.userDetailService = userDetailService;
        this.libraryService = libraryService;
        this.bookDetailService = bookDetailService;
    }

    @PostMapping("/addBook={userId}/bookId={bookId}")
    public ResponseEntity<String> addBookForUser(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId)
    {
        libraryService.addBookForUser(userId, bookDetailService.getBookById(bookId));
        return ResponseEntity.ok("Book added successfully for user");
    }

    @GetMapping("/removeBook={userId}/bookId={bookId}")
    public String removeBookForUser(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId)
    {
        return libraryService.removeBookForUser(userId,bookId);
    }
}
