package anas.kazay.libraryapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @OneToOne
    private BorrowRecord borrowRecord;

    private double amount;
    private Date paymentDate;
    private String status;
}
