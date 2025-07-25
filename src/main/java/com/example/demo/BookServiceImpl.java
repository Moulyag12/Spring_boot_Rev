package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.BookService;
import com.example.demo.Repository.BookRepository;
import com.example.demo.model.Book;

@Service
public class BookServiceImpl implements BookService {
      private final BookRepository repo;

   public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
       return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
              
        return repo.save(book);
    }

    // @PutMapping("/{id}")
    // public String updateBook(@PathVariable int id, @RequestBody Book updateBook) {
    //    for(Book book:booklist){
    //     if (book.getId() == id) {
    //             book.setTitle(updateBook.getTitle());
    //             book.setAuthor(updateBook.getAuthor());
    //             return "Book updated!";
    //    }
    // } 
    //     return "Book not found!!";
    // }
   
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id,@RequestBody Book updateBook){

      return repo.findById(id).map(existing->{
          existing.setTitle(updateBook.getTitle());
          existing.setAuthor(updateBook.getAuthor());
          return repo.save(existing);
      }).orElse(null);
    }




    // @DeleteMapping("/{id}")
    // public String deleteBook(@PathVariable int id){
    //     boolean deletedBook=booklist.removeIf(book->book.getId()==id);
    //     return deletedBook?"Book deleted":"Book not found";
    // }
      @DeleteMapping("/{id}")
     public void deleteBook(@PathVariable Integer id){
          repo.deleteById(id);
     }
    
    
}
