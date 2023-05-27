package com.io.collab.libraryManagementSystem.repo;

import com.io.collab.libraryManagementSystem.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {
    UserDetails findUserDetailsByName(String name);
}
