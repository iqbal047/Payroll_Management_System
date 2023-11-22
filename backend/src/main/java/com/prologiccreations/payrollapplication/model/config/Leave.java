package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Leave extends AuditableEntity {


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    private LocalDate startDate;
    private LocalDate endDate;
    private boolean approved;
    private String leaveType; // Example: Sick leave, Annual leave, Maternity leave, etc.
    private String reason;    // Reason for taking leave
    private boolean halfDay; // Whether it's a half-day leave


}
