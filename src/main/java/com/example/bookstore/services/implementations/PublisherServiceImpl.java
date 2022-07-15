package com.example.bookstore.services.implementations;

import com.example.bookstore.Repos.PublisherRepo;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.services.PublisherService;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepo publisherRepo;

    public PublisherServiceImpl(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepo.findAll();
    }

    @Override
    public Optional<Publisher> getByID(long id) {
        return publisherRepo.findById(id);
    }

    @Override
    public void deleteByID(long id) {
        publisherRepo.deleteById(id);
    }

    @Override
    public Publisher create(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        Publisher existingPublisher= null;
        try {
            existingPublisher = publisherRepo.findById(publisher.getId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingPublisher.setName(publisher.getName());
            existingPublisher.setId(publisher.getId());
            existingPublisher.setPublishedBooksList(publisher.getPublishedBooksList());
            publisherRepo.save(publisher);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }

    }
}
