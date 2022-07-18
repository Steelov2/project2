package com.example.bookstore.services;

import com.example.bookstore.entities.Author;

import java.util.List;
import java.util.Optional;
public interface AuthorService {
    List<Author> getAll();
    Optional<Author> getByID(long id);
    void deleteByID(long id);
    Author create(Author author);
    void update(Author author,long id);
    List<Author> getByNameContaining(String name);


}
