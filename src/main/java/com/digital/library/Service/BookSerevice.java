package com.digital.library.Service;


import com.digital.library.Entity.Book;
import com.digital.library.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookSerevice {

    // TODO Constructor injection of book repository for dependency injection.
    private BookRepository bookRepository;
    public BookSerevice(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


   // TODO Save the book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // TODO Delete book by id
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


    // TODO Update book
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        return bookRepository.save(existingBook);
    }
   // TODO get book by id
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // TODO Getting a list of all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


}
