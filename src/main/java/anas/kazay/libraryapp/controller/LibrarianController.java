package anas.kazay.libraryapp.controller;

import anas.kazay.libraryapp.model.Librarian;
import anas.kazay.libraryapp.repository.LibrarianRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {

    private final LibrarianRepository librarianRepository;

    public LibrarianController(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @GetMapping
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable Long id) {
        Optional<Librarian> librarian = librarianRepository.findById(id);
        return librarian.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Librarian createLibrarian(@RequestBody Librarian librarian) {
        librarian.setId(null); // Ensure Hibernate treats it as a new entry
        return librarianRepository.save(librarian);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Librarian> updateLibrarian(@PathVariable Long id, @RequestBody Librarian librarianDetails) {
        return librarianRepository.findById(id)
                .map(existingLibrarian -> {
                    existingLibrarian.setName(librarianDetails.getName());
                    existingLibrarian.setEmail(librarianDetails.getEmail());
                    return ResponseEntity.ok(librarianRepository.save(existingLibrarian));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable Long id) {
        if (librarianRepository.existsById(id)) {
            librarianRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
