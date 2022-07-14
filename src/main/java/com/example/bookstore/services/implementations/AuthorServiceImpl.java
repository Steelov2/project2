package com.example.bookstore.services.implementations;

import com.example.bookstore.Repos.AuthorRepo;
import com.example.bookstore.entities.Author;
import com.example.bookstore.services.AuthorService;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Optional<Author> getByID(long id) {
        return authorRepo.findById(id);
    }

    @Override
    public void deleteByID(long id) {
         authorRepo.deleteById(id);
    }

    @Override
    public Author create(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void update(Author author) {
        Author existingAuthor= null;
        try {
            existingAuthor = authorRepo.findById(author.getId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingAuthor.setName(author.getName());
            existingAuthor.setSurname(author.getSurname());
            existingAuthor.setPatronymic(author.getPatronymic());
            existingAuthor.setDateOfBirth(author.getDateOfBirth());
            existingAuthor.setId(author.getId());
            existingAuthor.setAuthorsBooksList(author.getAuthorsBooksList());
            authorRepo.save(author);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
    }
}
