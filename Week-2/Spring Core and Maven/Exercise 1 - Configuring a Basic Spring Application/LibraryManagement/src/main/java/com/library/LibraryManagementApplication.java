package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository repository = context.getBean(BookRepository.class);
        repository.findAllBooks();
        BookService service = context.getBean(BookService.class);
        service.getBooks();
        System.out.println("Spring context loaded successfully.");
        context.close();
    }
}