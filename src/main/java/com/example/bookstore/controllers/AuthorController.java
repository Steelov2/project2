package com.example.bookstore.controllers;

import com.example.bookstore.DTOs.AuthorDTO;
import com.example.bookstore.DTOs.GenreDTO;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.services.AuthorService;
import com.example.bookstore.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;
    private ModelMapper modelMapper;
    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/author")
    public List<AuthorDTO> getAll(){
        List<Author> authors=authorService.getAll();
        return authors.stream()
                .map(Author::convertAuthorToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/author/{authorID}")
    private Optional<AuthorDTO> getAuthorById(@PathVariable("authorID") long id)
    {
        Optional<Author> authors=authorService.getByID(id);
        return authors.map(Author::convertAuthorToDto);
    }
    @GetMapping("/author/genre/{genreName}")
    private Stream<AuthorDTO> getAuthorByGenreName(@PathVariable("genreName") String name)
    {
        List<Author> authorList=new ArrayList<>();
        bookService.getByGenreName(name)
                .stream()
                .forEach(book -> authorList.addAll(book.getAuthorList()));
        return authorList.stream().map(Author::convertAuthorToDto);

    }

    private GenreDTO convertGenreToDto(Genre genre) {
        GenreDTO genreDTO = modelMapper.map(genre, GenreDTO.class);
        genreDTO.setName(genre.getName());
        genreDTO.setId(genre.getId());


        return genreDTO;
    }


    @GetMapping("/author/name")
    private List<AuthorDTO> getAuthorByName( @RequestParam String name,
                                             @RequestParam String surname,
                                             @RequestParam String patronymic){
        List<Author> authors=authorService.getByNameSurnamePatronymicContaining(name, surname, patronymic);
        return authors
                .stream()
                .map(Author::convertAuthorToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/author/{authorID}")
    private void deleteAuthorById(@PathVariable("authorID") long id)
    {
        authorService.deleteByID(id);
    }
    @PostMapping("/author")
    private AuthorDTO saveBook(@RequestBody AuthorDTO authorDTO){
        Author author = authorDTO.convertToEntity();
        Author authorCreated = authorService.create(author);
        return authorCreated.convertAuthorToDto();
    }
    @PutMapping("/author/{authorID}")
    private void updateBook(@RequestBody AuthorDTO authorDTO,@PathVariable("authorID") long id) throws Throwable {
        if(!Objects.equals(id, authorDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Author author =authorDTO.convertToEntity();
        authorService.update(author,id);
    }





}
