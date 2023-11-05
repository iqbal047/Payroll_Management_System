package com.prologiccreations.payrollapplication.model.super_classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import static com.prologiccreations.payrollapplication.PayrollApplication.getCurrentUsername;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity extends BaseEntity {
    @JsonIgnore
    @CreatedBy
    private String createdBy;
    @JsonIgnore
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
    @JsonIgnore
    @LastModifiedBy
    private String modifiedBy;
    @JsonIgnore
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @PrePersist
    public void onPrePersist() {
        this.setActive(true);
        this.createdBy = getCurrentUsername();
        this.createdDate = LocalDateTime.now();

//        System.out.println("On create " + this.getClass().getName());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedBy = getCurrentUsername();
        this.modifiedDate = LocalDateTime.now();
//        System.out.println("On update " + this.getClass().getName());
    }

    @PreRemove
    public void onPreRemove() {
        this.setActive(false);
        this.modifiedBy = getCurrentUsername();
        this.modifiedDate = LocalDateTime.now();
//        System.out.println("On delete " + this.getClass().getName());
    }
}
