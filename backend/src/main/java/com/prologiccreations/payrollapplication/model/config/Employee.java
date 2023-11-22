package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Employee extends AuditableEntity {


    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private double nationalId;
    private String address;
    private String phone;
    private String email;




    private LocalDate employmentStartDate;

//    @ManyToOne
//    private Department department;

    private String department;
    private String designation;
//    private String position;
    private String employmentStatus;
    private String bankAccountDetails;

}
