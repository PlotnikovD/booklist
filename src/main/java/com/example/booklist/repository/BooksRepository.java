package com.example.booklist.repository;

import com.example.booklist.entity.Books;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Books, Long> {
    List<Books> findAll();

    List<Books> findByTitleContainingIgnoreCase(String title);

}
