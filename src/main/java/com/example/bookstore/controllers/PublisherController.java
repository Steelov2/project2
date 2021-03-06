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
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    public PublisherController(PublisherService publisherService){
        this.publisherService= publisherService;
    }

    @GetMapping("/publisher")
    public List<PublisherDTO> getAll(){
        List<Publisher> publishers=publisherService.getAll();
        return publishers.stream()
                .map(this::convertPublisherToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/publisher/{publisherID}")
    private Optional<PublisherDTO> getPublisherById(@PathVariable("publisherID") long id)
    {
        Optional<Publisher> publishers=publisherService.getByID(id);
        return publishers.map(this::convertPublisherToDto);
    }
    @GetMapping("/publisher/name/{bookName}")
    private List<PublisherDTO> getAuthorByName(@PathVariable("bookName") String name){
        List<Publisher> publishers=publisherService.getByNameContaining(name);
        return publishers
                .stream()
                .map(this::convertPublisherToDto)
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
        Publisher publisher = convertToEntity(publisherDTO);
        Publisher publisherCreated = publisherService.create(publisher);
        return convertPublisherToDto(publisherCreated);
    }
    @PutMapping("/publisher/{publisherID}")
    private void updatePublisher(@RequestBody PublisherDTO publisherDTO,@PathVariable("publisherID") long id)    {
        if(!Objects.equals(id, publisherDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Publisher publisher = convertToEntity(publisherDTO);
        publisherService.update(publisher);
    }


    private PublisherDTO convertPublisherToDto(Publisher publisher) {
        PublisherDTO publisherDTO = modelMapper.map(publisher, PublisherDTO.class);
        publisherDTO.setName(publisher.getName());
        publisherDTO.setId(publisher.getId());
        publisherDTO.setPublishedBooks(publisher.getPublishedBooksList());
        return publisherDTO;
    }

    public Publisher convertToEntity(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDTO.getName());
        publisher.setId(publisherDTO.getId());
        publisher.setPublishedBooksList(publisherDTO.getPublishedBooks());
        return publisher;
    }


}
