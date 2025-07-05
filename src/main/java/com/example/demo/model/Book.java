package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title is mandatory")
    @Size(max = 100,message = "Title must be atmost 100 characters")
    private String title;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100,message = "Title must be atmost 60 characters")
    private String author;
    
    public Book(){}

    public Book(int id,String title,String author){
        this.id=id;
        this.title=title;
        this.author=author;
    }
     public int getId() {
         return id;
         }
    public void setId(int id) {
         this.id = id;
         }

    public String getTitle() {
         return title; 
        }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getAuthor() { 
        return author; 
    }
    public void setAuthor(String author) {
         this.author = author; 
        }
}
