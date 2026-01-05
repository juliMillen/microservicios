package com.jm.libros.Controller;

import com.jm.libros.DTO.BookDTO;
import com.jm.libros.Entity.Book;
import com.jm.libros.Repository.IAuthorClient;
import com.jm.libros.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;



    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book toSearch = bookService.findByISBN(id);
        return new ResponseEntity<>(toSearch, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> listBooks = bookService.findAllByISBN();
        return new ResponseEntity<>(listBooks, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> saveBook(@RequestBody BookDTO book) {
        bookService.saveBook(book);
        return new ResponseEntity<>("Book saved", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id,@RequestBody Book book) {
        bookService.updateBook(id, book);
        return new ResponseEntity<>("Book updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.NO_CONTENT);
    }
}
