package com.example.bookstore.services;

import com.example.bookstore.entities.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
     List<Publisher> getAll();
     Optional<Publisher> getByID(long id);
     void deleteByID(long id);
     Publisher create(Publisher publisher);
     void update(Publisher publisher);
    List<Publisher> getByNameContaining(String name);
}
