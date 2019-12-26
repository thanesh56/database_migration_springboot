package com.javatechie.multiple.ds.api.service;


import com.javatechie.multiple.ds.api.model.book.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getAllBook();
    Book saveBook(Book book);
    void deleteBook();
    void deleteBookById(int id);
}
