package anas.kazay.libraryapp.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Administrator extends User {
    private String adminCode;
}