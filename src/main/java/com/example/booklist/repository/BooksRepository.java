package com.example.booklist.repository;

import com.example.booklist.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BooksRepository extends JpaRepository<Books, BigInteger> {
}
