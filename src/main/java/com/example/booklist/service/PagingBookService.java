package com.example.booklist.service;

import com.example.booklist.entity.Books;
import java.util.List;

public interface PagingBookService {
    List<Books> findPaginated(int pageNo, int pageSize);
}
