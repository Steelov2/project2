package com.example.bookstore.entities;

import com.example.bookstore.DTOs.AuthorDTO;
import com.example.bookstore.DTOs.BookDTO;

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
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name="patronymic")
    private String patronymic;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


    @OneToMany
    @JoinTable(
            name = "author_genre",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> authorsGenresList;

    public List<Genre> getAuthorsGenresList() {
        return authorsGenresList;
    }

    public void setAuthorsGenresList(List<Genre> authorsGenresList) {
        this.authorsGenresList = authorsGenresList;
    }

    public Author() {
    }

    public Author(String surname,
                  String name,
                  String patronymic,
                  LocalDate dateOfBirth,
                  List<Genre> authorsGenresList
                 ) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
//        this.authorsBooksList = authorsBooksList;
        this.authorsGenresList = authorsGenresList;
    }

    public Author(long id,
                  String surname,
                  String name,
                  String patronymic,
                  LocalDate dateOfBirth,
                  List<Genre> authorsGenresList) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
//        this.authorsBooksList = authorsBooksList;
        this.authorsGenresList = authorsGenresList;
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


    public AuthorDTO convertAuthorToDto() {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(this.getName());
        authorDTO.setSurname(this.getSurname());
        authorDTO.setId(this.getId());
        authorDTO.setPatronymic(this.getPatronymic());
        authorDTO.setPatronymic(this.getPatronymic());
       // authorDTO.setAuthorsGenresList(this.getAuthorsGenresList().stream().map(Genre::convertGenreToDto).toList());
//         authorDTO.setAuthorsBooksList(author.getAuthorsBooksList());
        authorDTO.setDateOfBirth(this.getDateOfBirth());
        //bookDto.setGenreList(book.getBooksGenresList().stream().map(Genre::convertGenreToDto).toList());

        return authorDTO;
    }
//    public List<BookDTO> getAuthorsBooksList() {
//        return authorsBooksList;
//    }
//
//    public void setAuthorsBooksList(List<BookDTO> authorsBooksList) {
//        this.authorsBooksList = authorsBooksList;
//    }
}
