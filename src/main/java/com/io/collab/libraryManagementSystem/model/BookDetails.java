package com.io.collab.libraryManagementSystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private String author;
    private String bookDescription;
    private String genre;
    private String isAvailable = "Available";

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserDetails userDetails;
}
