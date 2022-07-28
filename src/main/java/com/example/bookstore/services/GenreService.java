package com.example.bookstore.services;

import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.Publisher;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> getAll();
    Optional<Genre> getByID(long id);
    void deleteByID(long id);
    Genre create(Genre genre);
    void update(Genre genre, long id);
    List<Genre> getByNameContaining(String name);
}
