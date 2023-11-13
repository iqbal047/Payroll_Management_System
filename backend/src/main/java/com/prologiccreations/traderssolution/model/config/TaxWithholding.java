package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TaxWithholding extends AuditableEntity {



    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String taxType;
    private double taxAmount;

    // Getters and setters
}


