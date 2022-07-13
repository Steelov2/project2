package com.example.bookstore.DTOs;

import java.util.List;

public class PublisherDTO {
    private String name;

    private List<BookDTO> publishedBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDTO> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(List<BookDTO> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
}
