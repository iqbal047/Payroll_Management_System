package com.prologiccreations.traderssolution.model.auth;

import com.prologiccreations.traderssolution.model.super_classes.ApprovableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends ApprovableEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<Role> roles;

    @Override
    public String toString() {
        return username;
    }
}
