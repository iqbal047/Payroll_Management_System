package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department extends AuditableEntity {

    @ManyToOne
//    @JoinColumn(name = "department_head_employee_id")
    private Employee departmentHead;


    private String departmentName;
    private String description; // Description of the department
    private String location; // Location of the department




}
