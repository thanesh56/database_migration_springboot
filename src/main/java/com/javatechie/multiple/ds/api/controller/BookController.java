package com.javatechie.multiple.ds.api.controller;

import com.javatechie.multiple.ds.api.model.book.Book;
import com.javatechie.multiple.ds.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(required = true) int id){
        return bookService.getBookById(id);
    }


    @GetMapping("/books")
    public List<Book> getAllBook(){
       return bookService.getAllBook();
    }

    @PostMapping("/books")
    public Book addAllBook(@RequestBody(required = true) Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/books")
    public void deleteAllBook(){
        bookService.deleteBook();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable(required = true) int id){
        bookService.deleteBookById(id);
    }
}
