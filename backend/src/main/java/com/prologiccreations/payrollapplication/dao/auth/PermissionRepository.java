package com.prologiccreations.payrollapplication.dao.auth;

import com.prologiccreations.payrollapplication.dao.super_classes.CrudDao;
import com.prologiccreations.payrollapplication.model.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>, CrudDao<Permission, Long> {

    @Modifying
    @Query(value = "UPDATE Permission e " +
            "SET e.active = false " +
            "where e.id = :id")
    int softDeleteById(@Param("id") Long id);

}