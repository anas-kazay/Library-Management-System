package anas.kazay.libraryapp.repository;

import anas.kazay.libraryapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
