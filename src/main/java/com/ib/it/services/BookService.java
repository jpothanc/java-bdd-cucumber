package com.ib.it.services;

import com.ib.it.models.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private Map<String, Book> books;

    public BookService() {
        books = new HashMap<>();
        loadBooks();
    }
    public Book GetBookByIsbn(String isbn) {

        if (books.containsKey(isbn)) {
            return books.get(isbn);
        }
        throw new NoSuchElementException("Book not found");
    }

    /**
     * Load some books for testing
     */
    private void loadBooks() {

        books.put("isbn:1111", Book.builder()
                .isbn("isbn:1111")
                .title("Effective Java")
                .author("Joshua Bloch")
                .description("Covers best practices for Java programming")
                .build());

        books.put("isbn:2222", Book.builder()
                .isbn("isbn:2222")
                .title("Java Concurrency in Practice")
                .author("Brian Goetz")
                .description("Covers best practices for Java concurrency")
                .build());

        books.put("isbn:3333", Book.builder()
                .isbn("isbn:3333")
                .title("Java Generics and Collections")
                .author("Maurice Naftalin")
                .description("Covers best practices for Java generics and collections")
                .build());

    }
}
