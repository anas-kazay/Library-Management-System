package anas.kazay.libraryapp.repository;

import anas.kazay.libraryapp.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}
