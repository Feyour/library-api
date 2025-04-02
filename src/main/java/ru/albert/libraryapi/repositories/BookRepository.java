package ru.albert.libraryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.albert.libraryapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {}