package com.example.bookstore.interfaces;

import com.example.bookstore.entities.Author;

import java.util.List;

public interface AuthorProvider {
    List<Author> getAll();

}
