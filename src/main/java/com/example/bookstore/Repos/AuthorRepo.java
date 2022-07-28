package com.example.bookstore.Repos;

import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    List<Author> findByNameOrSurnameOrPatronymicContainingIgnoreCase(String name, String surname, String Patronymic);
//    @Query("SELECT u FROM Author u WHERE u.authorsGenresList LIKE %?1%")





}
//@Param("name")