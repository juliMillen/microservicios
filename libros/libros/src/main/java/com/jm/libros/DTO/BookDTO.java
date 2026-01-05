package com.jm.libros.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long numISBN;

    private String title;

    private LocalDate publicationDate;

    private String description;

    private List<Long> authorsId;
}
