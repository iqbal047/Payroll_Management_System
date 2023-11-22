package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Benefits extends AuditableEntity {


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate benefitEnrollmentDate;  // Start date of benefit availability
    private LocalDate benefitendDate; // End date of benefit availability
    private String benefitType;
    private String description; // Description of the benefit
    private boolean taxable; // Whether the benefit is taxable
    private String frequency; // Frequency of benefit (e.g., monthly, annually)
    private double benefitCost;














}
