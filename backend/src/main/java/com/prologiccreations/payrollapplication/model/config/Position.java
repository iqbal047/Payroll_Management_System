package com.prologiccreations.payrollapplication.model.config;

import com.prologiccreations.payrollapplication.model.super_classes.AuditableEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Position extends AuditableEntity {

    private String positionTitle;
    private double salaryRange;





//
//    private String positionTitle;
//    private double salaryRange; // Base salary for the position
//    private String description; // Description of the position
//    private int level; // Level or hierarchy of the position



}
