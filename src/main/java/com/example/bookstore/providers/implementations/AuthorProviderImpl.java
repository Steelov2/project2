package com.example.bookstore.providers.implementations;



import com.example.bookstore.entities.Author;
import com.example.bookstore.providers.AuthorProvider;

import java.util.ArrayList;
import java.util.List;

public class AuthorProviderImpl implements AuthorProvider {
    private static List<Author> authorList=new ArrayList<>();
    @Override
    public List<Author> getAll() {
        return this.authorList;
    }
}
