package com.example.bookstore.Repos;
import com.example.bookstore.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher,Long> {
}
