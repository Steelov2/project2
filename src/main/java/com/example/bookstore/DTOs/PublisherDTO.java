package com.example.bookstore.DTOs;

import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Publisher;

import java.util.List;

public class PublisherDTO {
    private long id;

    private String name;

    private List<Book> publishedBooks;

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

    public List<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(List<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
    public  Publisher convertToEntity( ) {
        Publisher publisher = new Publisher();
        publisher.setName(this.getName());
        publisher.setId(this.getId());
        publisher.setPublishedBooksList(this.getPublishedBooks());
        return publisher;
    }
}
