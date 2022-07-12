package com.example.booklist.repository;

import com.example.booklist.entity.Books;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Books, Long> {
    List<Books> findAll();

    List<Books> findAllByTitle(String title, Pageable pageable);

}
