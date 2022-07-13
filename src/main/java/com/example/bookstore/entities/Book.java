package com.example.bookstore.entities;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private long id;
    private int price;
    private List<Author> authorList;
    private String publisher;
    private String name;
    private int numberOfPages;
    private LocalDate yearOfIssue;


    public Book() {}

    public Book(long id, int price, List<Author> authorList,
                String publisher, String name, int numberOfPages, LocalDate yearOfIssue) {
        this.id = id;
        this.price = price;
        this.authorList = authorList;
        this.publisher = publisher;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.yearOfIssue = yearOfIssue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocalDate getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(LocalDate yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }
}
