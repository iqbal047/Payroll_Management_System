package com.prologiccreations.payrollapplication.model.auth;

import com.prologiccreations.payrollapplication.model.super_classes.ApprovableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@Setter
@Entity
public class Role extends ApprovableEntity implements GrantedAuthority {

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<Permission> permissions;

    @Override
    public String getAuthority() {
        return name;
    }
}
