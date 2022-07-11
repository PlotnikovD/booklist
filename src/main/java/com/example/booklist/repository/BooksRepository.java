package com.example.booklist.repository;

import com.example.booklist.entity.Books;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Books, BigInteger> {


}
