package com.example.bookstore.services;

import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAll();
    public List<Book> getByID(long id);
    public boolean deleteByID(long id);
    public Book create(Book book);
    public void update(Book book);
}
