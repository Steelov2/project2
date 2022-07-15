package com.example.bookstore.services;

import com.example.bookstore.DTOs.BookDTO;
import com.example.bookstore.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAll();
    public Optional<Book> getByID(long id);
    public void deleteByID(long id);
    public Book create(Book book);
    void update(Book book, long id);


}
