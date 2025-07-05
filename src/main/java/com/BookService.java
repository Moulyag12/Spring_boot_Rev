package com;

import java.util.List;
import com.example.demo.model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book addBook(Book book);
    Book updateBook(Integer id, Book book);
     void deleteBook(Integer id);
}
