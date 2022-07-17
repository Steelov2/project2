package com.example.bookstore.services;

import com.example.bookstore.entities.Author;

import java.util.List;
import java.util.Optional;
public interface AuthorService {
    public List<Author> getAll();
    public Optional<Author> getByID(long id);
    public void deleteByID(long id);
    public Author create(Author author);
    public void update(Author author,long id);
    public List<Author> getByNameContaining(String name);


}
