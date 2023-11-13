package com.prologiccreations.traderssolution.dao.auth;

import com.prologiccreations.traderssolution.dao.super_classes.CrudDao;
import com.prologiccreations.traderssolution.model.auth.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>, CrudDao<Permission, Long> {

    @Modifying
    @Query(value = "UPDATE Permission e " +
            "SET e.active = false " +
            "where e.id = :id")
    int softDeleteById(@Param("id") Long id);

}