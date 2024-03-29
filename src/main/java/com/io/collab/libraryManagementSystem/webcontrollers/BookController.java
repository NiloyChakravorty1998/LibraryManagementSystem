package com.io.collab.libraryManagementSystem.webcontrollers;

import com.io.collab.libraryManagementSystem.model.BookDetails;

import com.io.collab.libraryManagementSystem.service.book.BookDetailServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/updateBook={id}")
    public ResponseEntity<BookDetails> updateBook(@RequestBody BookDetails bookDetails, @PathVariable("id") Long id){
        bookDetailService.updateBookById(bookDetails,id);
        return ResponseEntity.ok(bookDetails);
    }

    @DeleteMapping("/deleteBookById={id}")
    public ResponseEntity<BookDetails> deleteBookByID(@RequestBody BookDetails bookDetails,Long id){
        bookDetailService.deleteBookById(id);
        return ResponseEntity.ok(bookDetails);
    }


    @GetMapping("/getAllBooks")
    public List<BookDetails> getAllBooks(){
        return bookDetailService.getAllBooks();

    }
    @GetMapping("/getAllBooksByAuthor={author}")
    public List<BookDetails> getBooksByAuthor(@PathVariable("author") String author) {
       return  bookDetailService.getBooksByAuthor(author, Pageable.ofSize(5));
    }
    @GetMapping("/getAllBooksByGenre={genre}")
    public List<BookDetails> getBooksByGenre(@PathVariable("genre") String genre) {
        return  bookDetailService.getBooksByGenre(genre, Pageable.ofSize(5));
    }


}

