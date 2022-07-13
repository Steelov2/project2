package com.example.bookstore.entities;

import java.time.LocalDate;
import java.util.List;

public class Author {

    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private List<Book> authorsBooksList;

    public Author() {
    }

    public Author(long id, String surname, String name,
                  String patronymic, LocalDate dateOfBirth, List<Book> authorsBooksList) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.authorsBooksList = authorsBooksList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getAuthorsBooksList() {
        return authorsBooksList;
    }

    public void setAuthorsBooksList(List<Book> authorsBooksList) {
        this.authorsBooksList = authorsBooksList;
    }
}
