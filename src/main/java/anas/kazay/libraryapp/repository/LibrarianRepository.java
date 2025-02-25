package anas.kazay.libraryapp.repository;

import anas.kazay.libraryapp.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
