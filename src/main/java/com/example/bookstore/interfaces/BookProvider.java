package com.example.bookstore.interfaces;

import com.example.bookstore.entities.Book;

import java.util.List;

public interface BookProvider {
    List<Book> getAll();
}
