package com.example.bookstore.services.implementations;

import com.example.bookstore.Repos.GenreRepo;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.services.GenreService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepo genreRepo;

    public GenreServiceImpl(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepo.findAll();
    }

    @Override
    public Optional<Genre> getByID(long id) {
        return genreRepo.findById(id);
    }

    @Override
    public void deleteByID(long id) {
        genreRepo.deleteById(id);
    }

    @Override
    public Genre create(Genre genre) {
        return (Genre) genreRepo.save(genre);
    }

    @Override
    public void update(Genre genre, long id)  {
        Genre existingGenre;
        try {
            existingGenre = (Genre) genreRepo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingGenre.setName(genre.getName());
            existingGenre.setId(genre.getId());
            genreRepo.save(genre);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Genre> getByNameContaining(String name) {
        return genreRepo.findByNameIsContainingIgnoreCase(name);
    }
}
