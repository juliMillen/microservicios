package com.jm.libros.Repository;

import com.jm.libros.DTO.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authorClient",url="http://localhost:8080")
public interface IAuthorClient {

    @GetMapping("/author/{id}")
    AuthorDTO getAuthor(@PathVariable Long id);
}
