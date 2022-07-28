package com.example.bookstore.controllers;

import com.example.bookstore.DTOs.AuthorDTO;
import com.example.bookstore.DTOs.BookDTO;

import com.example.bookstore.DTOs.PublisherDTO;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class BookController {
    private final BookService bookService;
    private ModelMapper modelMapper;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/book")
    public List<BookDTO> getAll(){
        List<Book> books=bookService.getAll();
        return books.stream()
                .map(Book::convertBookToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/book/{bookID}")
    private Optional<BookDTO> getBookById(@PathVariable("bookID") long id)
    {
        Optional<Book> books=bookService.getByID(id);
        return books.map(Book::convertBookToDto);
    }
    @GetMapping("/book/name/{bookName}")
    private List<BookDTO> getBookByName(@PathVariable("bookName") String name){
        List<Book> books=bookService.getByNameContaining(name);
        return books
                .stream()
                .map(Book::convertBookToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/book/genreName/{genreName}")
    private List<BookDTO> getBookByGenreName(@PathVariable("genreName") String name){
        List<Book> books=bookService.getByGenreName(name);
        return books
                .stream()
                .map(Book::convertBookToDto)
                .collect(Collectors.toList());
    }

//    private Optional<Book> getBookById(@PathVariable("bookID") long id)
//    {
//        return bookService.getByID(id);
//    }
    @DeleteMapping("/book/{bookID}")
    private void deleteBookById(@PathVariable("bookID") long id)
    {
        bookService.deleteByID(id);
    }
    @PostMapping("/book")
    private BookDTO saveBook(@RequestBody BookDTO bookDTO){
        Book book = bookDTO.convertToEntity();
        Book bookCreated = bookService.create(book);
        return bookCreated.convertBookToDto();
    }
    @PutMapping("/book/{bookID}")
    private void updateBook(@RequestBody BookDTO bookDTO,@PathVariable("bookID") long id)    {
        if(!Objects.equals(id, bookDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Book book = bookDTO.convertToEntity();
        bookService.update(book,id);
    }



}

//@PathVariable("bookid") long id
//book.getId()