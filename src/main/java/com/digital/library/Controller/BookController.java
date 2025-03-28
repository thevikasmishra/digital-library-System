package com.digital.library.Controller;

import com.digital.library.Entity.Book;
import com.digital.library.Service.BookSerevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    // Inject the service
    private BookSerevice bookService;
    //inject the book service
    public BookController(BookSerevice bookService) {
        this.bookService = bookService;
    }

    // Add a new book
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>("Book saved successfully", HttpStatus.CREATED);
    }

    // Update book details
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete a book
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }

    // Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // List all books
    @GetMapping("/all")
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
}
