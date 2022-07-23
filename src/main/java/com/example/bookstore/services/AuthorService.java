package com.example.bookstore.services;

import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Genre;

import java.util.List;
import java.util.Optional;
public interface AuthorService {
    List<Author> getAll();
    Optional<Author> getByID(long id);
    void deleteByID(long id);
    Author create(Author author);
    void update(Author author,long id) throws Throwable;
    List<Author> getByNameSurnamePatronymicContaining(String name, String surname, String patronymic);
    //Optional<Genre> getAuthorsByGenreName(String name);


}
