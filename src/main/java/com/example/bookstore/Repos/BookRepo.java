package com.example.bookstore.Repos;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    List<Book> findByNameIsContainingIgnoreCase(String name);

}
