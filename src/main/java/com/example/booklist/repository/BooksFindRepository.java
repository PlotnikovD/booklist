package com.example.booklist.repository;

import com.example.booklist.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface BooksFindRepository extends JpaRepository<Books, BigInteger> {
    List<Books> findByTitleContainingIgnoreCase(String title);

}
