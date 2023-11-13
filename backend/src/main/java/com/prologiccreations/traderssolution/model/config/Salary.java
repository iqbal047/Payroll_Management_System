package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Salary extends AuditableEntity {


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private double salaryAmount;
    private String payFrequency;
    private double deductions;
    private double bonuses;


    // Other fields (deductions, bonuses, etc.)

    // Getters and setters
}
