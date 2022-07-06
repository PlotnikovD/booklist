package com.example.booklist.service;

import com.example.booklist.controller.dto.BooksRequestDto;
import com.example.booklist.controller.dto.BooksResponceDto;
import com.example.booklist.entity.Books;
import com.example.booklist.exception.BookNotFoundException;
import com.example.booklist.repository.BooksRepository;
import liquibase.repackaged.org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksResponceDto createBook(BooksRequestDto booksRequestDto) {
        Books books = new Books(booksRequestDto.getTitle(), booksRequestDto.getDescription(), booksRequestDto.getAuthor(),
                booksRequestDto.getIsbn(), booksRequestDto.getPrintYear(), booksRequestDto.isReadAlready());
        booksRepository.save(books);
        return new BooksResponceDto(books.getId(), books.getTitle(), books.getDescription(), books.getAuthor(),
                books.getIsbn(), books.getPrintYear(), books.isReadAlready());
    }

    public Books getBookById(BigInteger id) {
        return booksRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Книга по id - " + id + " не найдена"));
    }

    public List<Books> getAll() {
        return booksRepository.findAll();
    }

    public void update(Books books) {
        Books book = booksRepository.findById(books.getId())
                .orElseThrow(() -> new BookNotFoundException("Не найдено"));
        book.setTitle(books.getTitle());
        book.setDescription(books.getDescription());
        book.setIsbn(books.getIsbn());
        book.setPrintYear(books.getPrintYear());
        book.setReadAlready(false);
        booksRepository.save(book);

    }

    public void readAlready(BigInteger id) {
        Books book = booksRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Книга не найдена"));
        if (BooleanUtils.isFalse(book.isReadAlready())) {
            book.setReadAlready(true);
            booksRepository.save(book);
        }
    }
}
