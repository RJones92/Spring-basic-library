package com.example.spring5webapp.repositories;

import com.example.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

//Spring data JPA will provide the implementation at runtime

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
