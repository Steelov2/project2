package com.example.bookstore.services;

import com.example.bookstore.entities.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    public List<Publisher> getAll();
    public Optional<Publisher> getByID(long id);
    public void deleteByID(long id);
    public Publisher create(Publisher publisher);
    public void update(Publisher publisher);
}
