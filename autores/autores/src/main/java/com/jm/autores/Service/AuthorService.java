package com.jm.autores.Service;

import com.jm.autores.DTO.AuthorDTO;
import com.jm.autores.Entity.Author;
import com.jm.autores.Repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private IAuthorRepository authorRepository;


    public AuthorDTO findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));

        return new AuthorDTO(
                author.getId(),
                author.getFullName(),
                author.getNationality()
        );
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findByFullName(String fullName) {
        return authorRepository.findByFullName(fullName);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        }else{
            throw new RuntimeException("The author with id " + id + " was not found");
        }
    }

    public void updateAuthor(Long id,Author author) {
        if(id == null){
            throw new RuntimeException("Id is null");
        }
        Author toUpdate= authorRepository.findById(id).orElseThrow(() -> new RuntimeException("The author with id " + id + " was not found"));
        toUpdate.setFullName(author.getFullName());
        toUpdate.setBirthDate(author.getBirthDate());
        toUpdate.setNationality(author.getNationality());
        toUpdate.setListBooks(author.getListBooks());
        authorRepository.save(toUpdate);
    }
}
