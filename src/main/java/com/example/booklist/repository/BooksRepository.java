package com.example.booklist.repository;

import com.example.booklist.entity.Books;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Books, Long> {
    List<Books> findAll();

    List<Books> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
    List<Books> findAllByTitleContainingIgnoreCase(String title);



}
