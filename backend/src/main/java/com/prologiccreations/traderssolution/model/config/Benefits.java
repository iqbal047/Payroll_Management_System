package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Benefits extends AuditableEntity {


//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;

    private String benefitType;
    private double benefitCost;
//    private Date benefitEnrollmentDate;


}