package ru.albert.libraryapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.albert.libraryapi.model.Book;
import ru.albert.libraryapi.repositories.BookRepository;
import ru.albert.libraryapi.servies.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Book book) {
        bookService.save(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
