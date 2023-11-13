package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employee extends AuditableEntity {


    private String firstName;
    private String lastName;
//    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;


    // Other fields (address, phone, email, etc.)

//    private Date employmentStartDate;
    private String employmentStartDate;
    private String department;
    private String position;
    private String employmentStatus;
    private String bankAccountDetails;

    // Other fields (bank account details, etc.)

    // Getters and setters
}
