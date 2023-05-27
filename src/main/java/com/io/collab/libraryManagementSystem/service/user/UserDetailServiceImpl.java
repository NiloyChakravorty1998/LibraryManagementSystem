package com.io.collab.libraryManagementSystem.service.user;


import com.io.collab.libraryManagementSystem.model.BookDetails;
import com.io.collab.libraryManagementSystem.model.UserDetails;
import com.io.collab.libraryManagementSystem.repo.UserDetailsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService{

    private UserDetailsRepo userRepo;



    public UserDetailServiceImpl(UserDetailsRepo userRepo) {
        this.userRepo = userRepo;

    }

    @Override
    public UserDetails getUserById(Long id) {
        return userRepo.getReferenceById(id);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails createNewUser(UserDetails user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUsersById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<BookDetails> bookIssuedByUserById(Long id) {
        List<BookDetails> booksIssued= userRepo.getReferenceById(id).getListOfBooks();
        return booksIssued;
    }

    @Override
    public UserDetails updateUser(UserDetails user, Long id) {
        UserDetails userToBeUpdated = new UserDetails();
        userToBeUpdated.setUserId(id);
        userToBeUpdated.setListOfBooks(user.getListOfBooks());
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setEmailAddress(user.getEmailAddress());
        userToBeUpdated.setPassword(user.getPassword());
        userToBeUpdated.setNumberOfBooks(user.getListOfBooks().size());
        userRepo.save(userToBeUpdated);
        return userToBeUpdated;
    }

    @Override
    public UserDetails findUserDetailsByName(String name) {
        return userRepo.findUserDetailsByName(name);
    }
}
