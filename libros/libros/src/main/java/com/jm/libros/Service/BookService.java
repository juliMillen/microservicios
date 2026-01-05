package com.jm.libros.Service;

import com.jm.libros.Entity.Book;
import com.jm.libros.Repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;


    public Book findByISBN(Long numISBN){
        if(numISBN == null){
            throw  new IllegalArgumentException("El ISBN no puede ser nulo");
        }
        Book search = bookRepository.findById(numISBN).orElse(null);
        return search;
    }

    public List<Book> findAllByISBN(){
        return bookRepository.findAll();
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Long num,Book book){
        if(num == null){
            throw  new IllegalArgumentException("El ISBN no puede ser nulo");
        }
        Book toUpdate = bookRepository.findById(num).orElse(null);
        toUpdate.setTitle(book.getTitle());
        toUpdate.setPublicationDate(book.getPublicationDate());
        toUpdate.setDescription(book.getDescription());
        toUpdate.setAuthors(book.getAuthors());
        bookRepository.save(toUpdate);
    }

    public void deleteBook(Long num){
        if(num == null){
            throw  new IllegalArgumentException("El ISBN no puede ser nulo");
        }
        bookRepository.deleteById(num);
    }

}
