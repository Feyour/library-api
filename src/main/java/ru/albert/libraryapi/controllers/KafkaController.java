package ru.albert.libraryapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.albert.libraryapi.kafka.KafkaProducer;
import ru.albert.libraryapi.repositories.BookRepository;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final BookRepository bookRepository;

    public KafkaController(KafkaProducer kafkaProducer, BookRepository bookRepository) {
        this.kafkaProducer = kafkaProducer;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestParam int id) {
        var book = bookRepository.findById(id);
        kafkaProducer.sendMessage(book.toString());
        return "Successfully sent book " + id;
    }

    @PostMapping("/kafka/sendAll")
    public String sendAll() {
        var books = bookRepository.findAll();
        books.forEach(book -> kafkaProducer.sendMessage(book.toString()));
        return "Successfully sent all books";
    }
}
