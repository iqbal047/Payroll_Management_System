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
public class Leave extends AuditableEntity {


//    private Date startDate;
//    private Date endDate;
    private boolean approved;
    private String leaveType; // Example: Sick leave, Annual leave, Maternity leave, etc.
    private String reason;    // Reason for taking leave
    private boolean halfDay; // Whether it's a half-day leave


//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;


}
