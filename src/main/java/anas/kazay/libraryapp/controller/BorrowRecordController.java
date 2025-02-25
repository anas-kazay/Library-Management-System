package anas.kazay.libraryapp.controller;

import anas.kazay.libraryapp.model.BorrowRecord;
import anas.kazay.libraryapp.repository.BorrowRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow-records")
public class BorrowRecordController {

    private final BorrowRecordRepository borrowRecordRepository;

    public BorrowRecordController(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    @PostMapping
    public BorrowRecord createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        borrowRecord.setId(null);
        return borrowRecordRepository.save(borrowRecord);
    }

    @GetMapping("/{id}")
    public BorrowRecord getBorrowRecordById(@PathVariable Long id) {
        return borrowRecordRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public BorrowRecord updateBorrowRecord(@PathVariable Long id, @RequestBody BorrowRecord borrowRecordDetails) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElseThrow();
        borrowRecord.setReturnDate(borrowRecordDetails.getReturnDate());
        borrowRecord.setReturned(borrowRecordDetails.isReturned());
        return borrowRecordRepository.save(borrowRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowRecord(@PathVariable Long id) {
        borrowRecordRepository.deleteById(id);
    }
}
