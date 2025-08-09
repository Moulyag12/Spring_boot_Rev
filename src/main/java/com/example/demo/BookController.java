package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.BookService;
import com.example.demo.model.Book;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/books")
public class BookController {
    // private List<Book> booklist=new ArrayList<>(List.of(
    //  new Book(1,"java basics","john"),
    //  new Book(2,"spring book","Jane")
    // ));

  private final BookService service;
  public BookController(BookService service){
      this.service=service;
  }
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
       return service.getBookById(id);
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
              
        return service.addBook(book);
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

      return service.updateBook(id, updateBook);
    }




    // @DeleteMapping("/{id}")
    // public String deleteBook(@PathVariable int id){
    //     boolean deletedBook=booklist.removeIf(book->book.getId()==id);
    //     return deletedBook?"Book deleted":"Book not found";
    // }
      @DeleteMapping("/{id}")
     public void deleteBook(@PathVariable Integer id){
         service.deleteBook(id);
     } 
}
