package com.example.bookstore.Repos;

import com.example.bookstore.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a WHERE a.name LIKE %:name%")
    List<Author> findByNameContaining(@Param("name") String name);
}
