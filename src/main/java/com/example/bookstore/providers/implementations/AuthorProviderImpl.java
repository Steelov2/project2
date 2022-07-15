package com.example.bookstore.providers.implementations;



import com.example.bookstore.entities.Author;
import com.example.bookstore.services.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorProviderImpl implements AuthorService {
    private static List<Author> authorList=new ArrayList<>();
    @Override
    public List<Author> getAll() {
        return this.authorList;
    }

    @Override
    public Optional<Author> getByID(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteByID(long id) {

    }

    @Override
    public Author create(Author author) {
        return null;
    }

    @Override
    public void update(Author author, long id) {

    }


}
