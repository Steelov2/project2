package com.example.bookstore.controllers;

import com.example.bookstore.DTOs.AuthorDTO;
import com.example.bookstore.DTOs.BookDTO;
import com.example.bookstore.DTOs.PublisherDTO;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.services.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    private ModelMapper modelMapper;
    private final PublisherService publisherService;
    @Autowired
    public PublisherController(PublisherService publisherService){
        this.publisherService= publisherService;
    }

    @GetMapping("/publisher")
    public List<PublisherDTO> getAll(){
        List<Publisher> publishers=publisherService.getAll();
        return publishers.stream()
                .map(Publisher::convertPublisherToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/publisher/{publisherID}")
    private Optional<PublisherDTO> getPublisherById(@PathVariable("publisherID") long id)
    {
        Optional<Publisher> publishers=publisherService.getByID(id);
        return publishers.map(Publisher::convertPublisherToDto);
    }
    @GetMapping("/publisher/name/{bookName}")
    private List<PublisherDTO> getAuthorByName(@PathVariable("bookName") String name){
        List<Publisher> publishers=publisherService.getByNameContaining(name);
        return publishers
                .stream()
                .map(Publisher::convertPublisherToDto)
                .collect(Collectors.toList());
    }
    @DeleteMapping("/publisher/{publisherID}")
    private void deletePublisherById(@PathVariable("publisherID") long id)
    {
        publisherService.deleteByID(id);
    }
    @PostMapping("/publisher")
    private PublisherDTO savePublisher(@RequestBody PublisherDTO publisherDTO)
    {
        Publisher publisher = publisherDTO.convertToEntity();
        Publisher publisherCreated = publisherService.create(publisher);
        return publisherCreated.convertPublisherToDto();
    }
    @PutMapping("/publisher/{publisherID}")
    private void updatePublisher(@RequestBody PublisherDTO publisherDTO,@PathVariable("publisherID") long id)    {
        if(!Objects.equals(id, publisherDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Publisher publisher = publisherDTO.convertToEntity();
        publisherService.update(publisher,id);
    }







}
