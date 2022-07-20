package com.example.booklist.controller;

import com.example.booklist.controller.dto.BooksRequestDto;
import com.example.booklist.controller.dto.BooksResponceDto;
import com.example.booklist.entity.Books;
import com.example.booklist.service.BooksService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    public BooksResponceDto createBook(@RequestBody BooksRequestDto booksRequestDto) {
        return booksService.createBook(booksRequestDto);
    }

    @GetMapping("/books/{id}")
    public BooksResponceDto getBook(@PathVariable Long id) {
        return new BooksResponceDto(booksService.getBookById(id));
    }

    @GetMapping("/books")
    public List<BooksResponceDto> getAll() {
        return booksService.getAll().stream().map(BooksResponceDto::new).collect(Collectors.toList());
    }

    @PutMapping("/books")
    public Books update(@RequestBody Books books) {
        booksService.update(books);
        return books;
    }

    @PutMapping("/readAlready")
    public void readAlready(@PathVariable Long id) {
        booksService.readAlready(id);
    }

    @GetMapping("/search")
    public List<Books> getByOptionalParam(@RequestParam(required = false) String searchTitle,
                                          @RequestParam(required = false) Integer pageNo,
                                          @RequestParam(required = false) Integer pageSize) {
        return booksService.findByOptionalParam(searchTitle, pageNo, pageSize);
    }


    AmqpTemplate template;

    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        System.out.println("Emit to get");
        template.convertAndSend("request","Message to get");
        return "Emit to get";
    }

}



