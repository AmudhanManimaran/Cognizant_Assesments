package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    // Dependency injected by Spring
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void getBooks() {
        System.out.println("BookService: Processing request to get all books.");
        bookRepository.findAllBooks();
    }
}