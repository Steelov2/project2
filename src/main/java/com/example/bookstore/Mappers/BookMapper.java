//package com.example.bookstore.Mappers;
//
//import com.example.bookstore.DTOs.BookDTO;
//import com.example.bookstore.entities.Author;
//import com.example.bookstore.entities.Book;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//import static java.util.stream.Collectors.toList;
//
//@Component
//class Mapper {
//    public BookDTO toDto(Book book) {
//        long id=book.getId();
//        int price= book.getPrice();
//        String name = book.getName();
//        List<Author> authorList = book
//                .getAuthorList()
//                .stream()
//                .map(Book::get)
//                .collect(toList());
//
//        return new BookDTO();
//    }
//
////    public Book toUser(UserCreationDTO userDTO) {
////        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
////    }
//}