package ru.albert.libraryapi.servies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albert.libraryapi.model.Book;
import ru.albert.libraryapi.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }
}
