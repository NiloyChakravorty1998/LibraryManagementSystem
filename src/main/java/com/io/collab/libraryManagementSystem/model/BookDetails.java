package com.io.collab.libraryManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
    private String isAvailable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails userDetails;
}
