package com.example.bookstore.DTOs;


import com.example.bookstore.entities.Author;


import java.time.LocalDate;
import java.util.List;


public class BookDTO{
    private long id;
    private int price;
    private List<AuthorDTO> authorList;
    private String publisher;
    private String name;
    private int numberOfPages;
    private LocalDate yearOfIssue;

    private List<GenreDTO> genreList;

    public List<GenreDTO> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<GenreDTO> genreList) {
        this.genreList = genreList;
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

    public List<AuthorDTO> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorDTO> authorList) {
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
