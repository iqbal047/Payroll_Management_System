package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PayrollTransaction extends AuditableEntity {



    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String payrollPeriod;

    @ManyToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

    private double hoursWorked;
    private double overtimeHours;
    private double grossEarnings;
    private double deductions;
    private double netPay;


}
