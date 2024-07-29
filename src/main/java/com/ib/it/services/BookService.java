package com.ib.it.services;

import com.ib.it.models.Book;
import com.ib.it.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book GetBookByIsbn(String isbn) {

        var book = bookRepository.GetBookByIsbn(isbn);
        if (book.isPresent())
            return book.get();

        throw new NoSuchElementException("Book not found");
    }
}
