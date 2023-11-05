package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Employee extends AuditableEntity {


    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;


    // Other fields (address, phone, email, etc.)

    private Date employmentStartDate;
    private String department;
    private String position;
    private String employmentStatus;
    private String bankAccountDetails;

    // Other fields (bank account details, etc.)

    // Getters and setters
}
