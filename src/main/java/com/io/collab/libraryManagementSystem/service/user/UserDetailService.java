package com.io.collab.libraryManagementSystem.service.user;

import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.model.UserDetails;


import java.util.List;

public interface UserDetailService {
    UserDetails getUserById(Long id);
    List<UserDetails> getAllUsers();
    UserDetails createNewUser(UserDetails user);
    void deleteUsersById(Long id);
    List<BookDetails> bookIssuedByUserById(Long id);
    UserDetails updateUser(UserDetails user, Long id);
    UserDetails findUserDetailsByName(String name);
}
