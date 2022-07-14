package com.example.bookstore.services;

import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Publisher;

import java.util.List;

public interface PublisherService {
    public List<Publisher> getAll();
    public List<Publisher> getByID(long id);
    public boolean deleteByID(long id);
    public Publisher create(Publisher publisher);
    public void update(Publisher publisher);
}
