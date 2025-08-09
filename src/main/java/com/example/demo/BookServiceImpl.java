package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.BookRepository;
import com.example.demo.model.Book;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return repo.save(book);
    }

    @Override
    public Book updateBook(Integer id, Book updateBook) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(updateBook.getTitle());
            existing.setAuthor(updateBook.getAuthor());
            return repo.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteBook(Integer id) {
        repo.deleteById(id);
    }
}