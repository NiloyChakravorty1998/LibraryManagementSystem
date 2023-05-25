package com.io.collab.libraryManagementSystem.webcontrollers;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.service.BookDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookDetailServiceImpl bookDetailService;

    public BookController(BookDetailServiceImpl bookDetailService) {
        this.bookDetailService = bookDetailService;
    }

    @PostMapping("/newBook")
    public ResponseEntity<BookDetails> saveNewBook(@RequestBody BookDetails bookDetails)
    {
        bookDetailService.saveBook(bookDetails);
        return ResponseEntity.ok(bookDetails);
    }

    @GetMapping("/bookId={id}")
    public BookDetails getBookDetailsById(@PathVariable("id") Long id)
    {
        return bookDetailService.getBookById(id);
    }


}
