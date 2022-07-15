package com.example.bookstore.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="AUTHOR")
public class Author {
    @Id
    @SequenceGenerator(
            name="author_sequence",
            sequenceName="author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    @ManyToMany
    @JoinTable(
            name = "authors_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> authorsBooksList;

    public Author() {
    }

    public Author(String surname,
                  String name,
                  String patronymic,
                  LocalDate dateOfBirth,
                  List<Book> authorsBooksList) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.authorsBooksList = authorsBooksList;
    }

    public Author(long id,
                  String surname,
                  String name,
                  String patronymic,
                  LocalDate dateOfBirth,
                  List<Book> authorsBooksList) {
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
