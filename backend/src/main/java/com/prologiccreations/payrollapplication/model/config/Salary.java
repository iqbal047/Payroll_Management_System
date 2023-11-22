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







//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    private double salaryAmount;
//    private LocalDate dateIssued;
//    private String currency; // Currency of the salary
//    private String paymentMethod; // Payment method (e.g., direct deposit, check, etc.)
//    private String payPeriod; // Frequency of payment (e.g., monthly, bi-weekly)
//    private double deductions; // Deduction amount
//    private double bonus; // Bonus amount






}
