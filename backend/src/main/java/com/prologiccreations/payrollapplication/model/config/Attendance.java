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
public class Attendance extends AuditableEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate logDate;

    private boolean present;


    private String remarks; // Remarks related to attendance (e.g., reasons for absence, late arrival, etc.)
    private int hoursWorked; // Hours worked on that day
    private boolean overtime; // Whether the hours worked exceed regular working hours

    private String location; // Location of work (if applicable, for remote work or multiple work sites)



}
