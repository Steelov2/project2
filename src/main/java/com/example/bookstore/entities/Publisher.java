package com.example.bookstore.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "PUBLISHER")
public class Publisher {
    @Id
    @SequenceGenerator(
            name="publisher_sequence",
            sequenceName="publisher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "publisher_sequence"
    )
    private long id;
    private String name;
    @OneToMany(mappedBy = "publisher")
    private List<Book> publishedBooksList;

    public Publisher() {
    }

    public Publisher(String name,
                     List<Book> publishedBooksList) {
        this.name = name;
        this.publishedBooksList = publishedBooksList;
    }

    public Publisher(long id,
                     String name,
                     List<Book> publishedBooksList) {
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
