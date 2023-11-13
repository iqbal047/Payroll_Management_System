package com.prologiccreations.traderssolution.model.super_classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * For Maker-Checker feature
 */
@Getter
@Setter
@MappedSuperclass
public abstract class ApprovableEntity extends AuditableEntity {
    @JsonIgnore
    private boolean isApproved;
    @JsonIgnore
    private String approvedBy;
    @JsonIgnore
    private String denialReason;
    @JsonIgnore
    private LocalDateTime approvedAt;

}
