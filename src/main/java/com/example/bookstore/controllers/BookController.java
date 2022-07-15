package com.example.bookstore.controllers;

import com.example.bookstore.DTOs.BookDTO;
import com.example.bookstore.entities.Book;
import com.example.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/book")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @GetMapping("/book/{bookID}")
    private Optional<Book> getBookById(@PathVariable("bookID") long id)
    {
        return bookService.getByID(id);
    }
    @DeleteMapping("/book/{bookID}")
    private void deleteBookById(@PathVariable("bookID") long id)
    {
        bookService.deleteByID(id);
    }
    @PostMapping("/book")
    private long saveBook(@RequestBody Book book)
    {
        bookService.create(book);
        return book.getId();
    }
    @PutMapping("/book/{bookID}")
    private void updateBook(@RequestBody Book book,@PathVariable("bookID") long id)    {
        bookService.update(book,id);
    }
}

//@PathVariable("bookid") long id
//book.getId()