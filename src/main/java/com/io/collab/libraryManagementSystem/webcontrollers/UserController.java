package com.io.collab.libraryManagementSystem.webcontrollers;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.model.UserDetails;
import com.io.collab.libraryManagementSystem.service.book.BookDetailServiceImpl;
import com.io.collab.libraryManagementSystem.service.library.LibraryService;
import com.io.collab.libraryManagementSystem.service.library.LibraryServiceImpl;
import com.io.collab.libraryManagementSystem.service.user.UserDetailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserDetailServiceImpl userDetailService;
    private LibraryServiceImpl libraryService;
    private BookDetailServiceImpl bookDetailService;

    public UserController(UserDetailServiceImpl userDetailService, LibraryServiceImpl libraryService, BookDetailServiceImpl bookDetailService) {
        this.userDetailService = userDetailService;
        this.libraryService = libraryService;
        this.bookDetailService = bookDetailService;
    }

    @GetMapping("/all")
    public List<UserDetails> getAllUsers()
    {
        return userDetailService.getAllUsers();
    }

    @GetMapping("/userId={id}")
    public UserDetails getUser(@PathVariable("id") Long id)
    {
        return userDetailService.getUserById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<UserDetails> saveNewUser(@RequestBody UserDetails userDetails)
    {
        userDetailService.createNewUser(userDetails);
        return ResponseEntity.ok(userDetails);
    }

    @PostMapping("/deleteById={id}")
     public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)
    {
        userDetailService.deleteUsersById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @GetMapping("/issuedBooks={id}")
    public List<BookDetails> getIssuedBooksById(@PathVariable Long id)
    {
        return userDetailService.bookIssuedByUserById(id);
    }

    @PostMapping("/updateUser={id}")
    public ResponseEntity<UserDetails> updateUserById(@RequestBody UserDetails details, @PathVariable("id") Long id)
    {
        userDetailService.updateUser(details,id);
        return ResponseEntity.ok(details);
    }

}
