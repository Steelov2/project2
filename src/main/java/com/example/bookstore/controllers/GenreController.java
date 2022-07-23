package com.example.bookstore.controllers;

import com.example.bookstore.DTOs.BookDTO;
import com.example.bookstore.DTOs.GenreDTO;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.services.BookService;
import com.example.bookstore.services.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class GenreController {
    private final GenreService genreService;
    private ModelMapper modelMapper;

    @Autowired
    public GenreController( GenreService genreService) {
        this.genreService = genreService;

    }
    @GetMapping("/genre")
    public List<GenreDTO> getAll(){
        List<Genre> genres=genreService.getAll();
        return genres.stream()
                .map(Genre::convertGenreToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/genre/{genreID}")
    private Optional<GenreDTO> getBookById(@PathVariable("genreID") long id)
    {
        Optional<Genre> genres=genreService.getByID(id);
        return genres.map(Genre::convertGenreToDto);
    }
    @GetMapping("/genre/name/{genreName}")
    private List<GenreDTO> getAuthorByName(@PathVariable("genreName") String name){
        List<Genre> genres=genreService.getByNameContaining(name);
        return genres
                .stream()
                .map(Genre::convertGenreToDto)
                .collect(Collectors.toList());
    }

    //    private Optional<Book> getBookById(@PathVariable("bookID") long id)
//    {
//        return bookService.getByID(id);
//    }
    @DeleteMapping("/genre/{genreID}")
    private void deleteBookById(@PathVariable("genreID") long id)
    {
        genreService.deleteByID(id);
    }
    @PostMapping("/genre")
    private GenreDTO saveBook(@RequestBody GenreDTO genreDTO){
        Genre genre = convertToEntity(genreDTO);
        Genre genreCreated = genreService.create(genre);
        return genreCreated.convertGenreToDto();
    }
    @PutMapping("/genre/{genreID}")
    private void updateBook(@RequestBody GenreDTO genreDTO,@PathVariable("genreID") long id)    {
        if(!Objects.equals(id, genreDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Genre genre = convertToEntity(genreDTO);
        genreService.update(genre,id);
    }


    public Genre convertToEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setId(genreDTO.getId());
        return genre;
    }
}
