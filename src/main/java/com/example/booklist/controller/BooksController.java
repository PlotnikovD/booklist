package com.example.booklist.controller;

import com.example.booklist.controller.dto.BooksRequestDto;
import com.example.booklist.controller.dto.BooksResponceDto;
import com.example.booklist.entity.Books;
import com.example.booklist.service.BooksService;
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

/*    @GetMapping("/books/{pageNo}/{pageSize}")
    public List<Books> getPaginatedBooks(@PathVariable int pageNo, @PathVariable int pageSize) {
        return booksService.findPaginated(pageNo, pageSize);
    }*/

/*    @GetMapping("/search")
    public List<Books> searchTitle(@RequestParam(required = false) String searchTitle) {
        return booksService.findByTitleContainingIgnoreCase(searchTitle);

    }*/

    @GetMapping("/search")
    public List<Books> getBookByOptionalParam(@RequestParam(required = false) String searchTitle,
                                              @RequestParam(required = false) int pageNo,
                                              @RequestParam(required = false) int pageSize) {
        return booksService.findByOptionalParams(searchTitle, pageNo, pageSize);

}
}
