package com.example.bookstore.services;

import com.example.bookstore.DTOs.BookDTO;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
     List<Book> getAll();
     Optional<Book> getByID(long id);
     void deleteByID(long id);
     Book create(Book book);
    void update(Book book, long id);
     List<Book> getByNameContaining(String name);



}
