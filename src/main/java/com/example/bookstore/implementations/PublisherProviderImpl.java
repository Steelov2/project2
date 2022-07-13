package com.example.bookstore.implementations;


import com.example.bookstore.entities.Publisher;
import com.example.bookstore.interfaces.PublisherProvider;

import java.util.ArrayList;
import java.util.List;
public class PublisherProviderImpl implements PublisherProvider {
    private static List<Publisher> publisherList=new ArrayList<>();
    @Override
    public List<Publisher> getAll() {
        return this.publisherList;
    }
}

