package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 1. Dependency Bean (Non-public so it can reside in this single file)
class BookRepository {
    public void fetchAllBooks() {
        System.out.println("[Repository] Fetching all library books from database...");
    }
}

// 2. Service Bean utilizing Setter-Based Dependency Injection
class BookService {
    private BookRepository bookRepository;

    // Step 2: Setter method required by Spring IoC container for DI wiring
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[DI Success] BookRepository wired into BookService via Setter Injection.");
    }

    public void displayBooks() {
        System.out.println("[Service] Delegating call to BookRepository...");
        bookRepository.fetchAllBooks();
    }
}

// 3. Main Runner Class for Exercise 2
public class DependencyInjectionApplication {
    public static void main(String[] args) {
        System.out.println("--- Loading Spring Application Context ---");
        
        // Load configuration and trigger Dependency Injection
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Testing Dependency Injection ---");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.displayBooks();
        
        // Close context gracefully
        ((ClassPathXmlApplicationContext) context).close();
    }
}