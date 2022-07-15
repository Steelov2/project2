package com.example.bookstore.providers.implementations;


import com.example.bookstore.entities.Publisher;
import com.example.bookstore.services.PublisherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PublisherProviderImpl implements PublisherService {
    private static List<Publisher> publisherList=new ArrayList<>();
    @Override
    public List<Publisher> getAll() {
        return this.publisherList;
    }

    @Override
    public Optional<Publisher> getByID(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteByID(long id) {

    }

    @Override
    public Publisher create(Publisher publisher) {
        return null;
    }

    @Override
    public void update(Publisher publisher) {

    }
}

