package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class TimeOff extends AuditableEntity {


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String timeOffType;
    private Date startDate;
    private Date endDate;
    private String approvalStatus;

    // Getters and setters
}
