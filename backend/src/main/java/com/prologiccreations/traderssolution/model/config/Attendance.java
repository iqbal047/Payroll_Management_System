package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Attendance extends AuditableEntity {

//    private Date logDate;
//    private String logDate;
    private boolean isPresent;
//    private int PresentDays;

    private String remarks; // Remarks related to attendance (e.g., reasons for absence, late arrival, etc.)
    private int hoursWorked; // Hours worked on that day
    private boolean isOvertime; // Whether the hours worked exceed regular working hours
//    private int OvertimeHour; // Whether the hours worked exceed regular working hours
    private String location; // Location of work (if applicable, for remote work or multiple work sites)



//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;


    // Other attendance-related details


}
