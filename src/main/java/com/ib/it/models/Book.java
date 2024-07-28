package com.ib.it.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String description;
}
