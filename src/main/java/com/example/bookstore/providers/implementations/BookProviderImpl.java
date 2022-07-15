package com.example.bookstore.providers.implementations;

import com.example.bookstore.DTOs.BookDTO;
import com.example.bookstore.Repos.BookRepo;
import com.example.bookstore.entities.Book;
import com.example.bookstore.services.BookService;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public class BookProviderImpl implements BookService {
    private final BookRepo bookRepo;

    public BookProviderImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getByID(long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void deleteByID(long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book create(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void update(Book book, long id) {
        Book existingBook= null;
        try {
            existingBook = bookRepo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingBook.setName(book.getName());
            existingBook.setNumberOfPages(book.getNumberOfPages());
            existingBook.setPrice(book.getPrice());
            existingBook.setAuthorList(book.getAuthorList());
            existingBook.setId(book.getId());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setYearOfIssue(book.getYearOfIssue());
            bookRepo.save(book);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }

    }

}
