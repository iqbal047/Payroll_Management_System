package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class PaymentHistory extends AuditableEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    private LocalDate paymentDate;
    private double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;


}
