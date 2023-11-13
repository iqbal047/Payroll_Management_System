package com.prologiccreations.traderssolution.model.config;

import com.prologiccreations.traderssolution.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Department extends AuditableEntity {


    private String departmentName;
    private String description; // Description of the department
    private String location; // Location of the department

//    @ManyToOne
//    @JoinColumn(name = "department_head_employee_id")
//    private Employee departmentHead;


}
