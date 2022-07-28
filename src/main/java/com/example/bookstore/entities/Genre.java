package com.example.bookstore.entities;

import com.example.bookstore.DTOs.GenreDTO;

import javax.persistence.*;

@Entity
@Table(name = "GENRE")
public class Genre {
    @Id
    @SequenceGenerator(
            name="genre_sequence",
            sequenceName="genre_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
    )
    private long id;
    @Column(name = "name")
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
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

    public GenreDTO convertGenreToDto() {
        GenreDTO genreDTO =new GenreDTO();
        genreDTO.setName(this.getName());
        genreDTO.setId(this.getId());

        return genreDTO;
    }
}
