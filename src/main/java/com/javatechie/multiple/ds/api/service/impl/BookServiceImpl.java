package com.javatechie.multiple.ds.api.service.impl;

import com.javatechie.multiple.ds.api.book.repository.BookRepository;
import com.javatechie.multiple.ds.api.model.book.Book;
import com.javatechie.multiple.ds.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook() {
        bookRepository.deleteAll();

    }

    @Override
    public void deleteBookById(int id) {

        bookRepository.deleteById(id);
    }
}
