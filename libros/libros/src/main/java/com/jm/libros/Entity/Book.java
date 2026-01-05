package com.jm.libros.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numISBN;

    private String title;

    private LocalDate publicationDate;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authors;
}
