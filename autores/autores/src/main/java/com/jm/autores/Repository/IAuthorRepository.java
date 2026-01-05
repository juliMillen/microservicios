package com.jm.autores.Repository;

import com.jm.autores.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT aut FROM Author aut WHERE aut.fullName = :fullname")
    Author findByFullName(String fullName);
}
