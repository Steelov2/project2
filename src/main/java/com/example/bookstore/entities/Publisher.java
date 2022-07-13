package com.example.bookstore.entities;

import java.util.List;

public class Publisher {
    private long id;
    private String name;
    private List<Book> publishedBooksList;

    public Publisher() {
    }

    public Publisher(long id, String name, List<Book> publishedBooksList) {
        this.id = id;
        this.name = name;
        this.publishedBooksList = publishedBooksList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getPublishedBooksList() {
        return publishedBooksList;
    }

    public void setPublishedBooksList(List<Book> publishedBooksList) {
        this.publishedBooksList = publishedBooksList;
    }
}
