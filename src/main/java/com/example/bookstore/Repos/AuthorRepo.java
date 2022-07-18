package com.example.bookstore.Repos;

import com.example.bookstore.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    List<Author> findByNameIsContainingIgnoreCase(String name);

}
//@Param("name")