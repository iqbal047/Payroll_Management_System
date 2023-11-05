package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
