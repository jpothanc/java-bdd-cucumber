package com.ib.it.repository;

import com.ib.it.models.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepository {

    private Map<String, Book> books;

    public BookRepository() {
        books = new HashMap<>();
        loadBooks();
    }

    public Optional<Book> GetBookByIsbn(String isbn) {

        if (isbn == null) {
            return Optional.empty();
        }

        if (books.containsKey(isbn)) {
            return Optional.of(books.get(isbn));
        }
        return Optional.empty();
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
