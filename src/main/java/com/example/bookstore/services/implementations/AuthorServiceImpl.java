package com.example.bookstore.services.implementations;

import com.example.bookstore.Repos.AuthorRepo;
import com.example.bookstore.Repos.GenreRepo;
import com.example.bookstore.entities.Author;
import com.example.bookstore.services.AuthorService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo, GenreRepo genreRepo) {
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
    }

    private static Throwable get() {
        return new IllegalArgumentException("Author with id not found");
    }

    @Override
    public List<Author> getAll() {
        return authorRepo.findAll();
    }

    @Override
    public Optional<Author> getByID(long id) {
        return authorRepo.findById(id);
    }
    @Override
    public List<Author> getByNameSurnamePatronymicContaining(String name, String surname, String patronymic) {
       return authorRepo.findByNameOrSurnameOrPatronymicContainingIgnoreCase(name, surname,patronymic);   }

//    @Override
//    public Optional<Genre> getAuthorsByGenreName(String name) {
//        return authorRepo.findAuthorsByAuthorsGenresListIgnoreCase(name);
//    }


    @Override
    public void deleteByID(long id) {
         authorRepo.deleteById(id);
    }

    @Override
    public Author create(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void update(Author author,long id) throws Throwable {
        Author existingAuthor;

            existingAuthor = authorRepo.findById(id).orElseThrow();
            existingAuthor.setName(author.getName());
            existingAuthor.setSurname(author.getSurname());
            existingAuthor.setPatronymic(author.getPatronymic());
            existingAuthor.setDateOfBirth(author.getDateOfBirth());
            existingAuthor.setId(author.getId());
            //existingAuthor.setAuthorsBooksList(author.getAuthorsBooksList());
            authorRepo.save(author);

    }



}
