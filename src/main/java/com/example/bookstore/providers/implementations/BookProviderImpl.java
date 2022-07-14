package com.example.bookstore.providers.implementations;

import com.example.bookstore.entities.Book;
import com.example.bookstore.providers.BookProvider;

import java.util.ArrayList;
import java.util.List;

public class BookProviderImpl implements BookProvider {
    private static List<Book> bookList=new ArrayList<>();
    @Override
    public List<Book> getAll() {
        return this.bookList;
    }
}
