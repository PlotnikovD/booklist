package com.example.booklist.controller;

import com.example.booklist.controller.dto.BooksRequestDto;
import com.example.booklist.controller.dto.BooksResponceDto;
import com.example.booklist.entity.Books;
import com.example.booklist.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @PostMapping("/books")
    public BooksResponceDto createBook (@RequestBody BooksRequestDto booksRequestDto){
        return booksService.createBook(booksRequestDto);
    }

    @GetMapping("/books/{id}")
    public BooksResponceDto getBook(@PathVariable BigInteger id){
        return new BooksResponceDto(booksService.getBookById(id));
    }

    @GetMapping("/books")
    public List<BooksResponceDto> getAll() {
        return booksService.getAll().stream().map(BooksResponceDto::new).collect(Collectors.toList());
    }

    @PutMapping("/books")
    public Books update(@RequestBody Books books){
        booksService.update(books);
        return books;
    }

    @PutMapping("/readAlready")
    public void readAlready(@PathVariable BigInteger id){
        booksService.readAlready(id);

    }

}
