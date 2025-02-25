package anas.kazay.libraryapp.repository;

import anas.kazay.libraryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
