package com.ib.it.controllers;

import com.ib.it.models.Book;
import com.ib.it.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@Tag(name = "BookController", description = "Book Service API")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get Book by ISBN", description = "Get Book by ISBN")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Book data found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/book")
    public ResponseEntity<Book> getBookByIsbn(@RequestParam String bookIsbn) {
        try {
            return ResponseEntity.ok(bookService.GetBookByIsbn(bookIsbn));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
