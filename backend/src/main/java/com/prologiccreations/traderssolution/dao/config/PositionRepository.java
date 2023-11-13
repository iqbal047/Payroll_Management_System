package com.prologiccreations.traderssolution.dao.config;

import com.prologiccreations.traderssolution.dao.super_classes.CrudDao;
import com.prologiccreations.traderssolution.model.config.Department;
import com.prologiccreations.traderssolution.model.config.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>, CrudDao<Position, Long> {


    @Modifying
    @Query(value = "UPDATE Position e " +
            "SET e.active = false, e.modifiedBy = :modifiedBy, e.modifiedDate = :modifiedDate " +
            "where e.id = :id")
    int softDeleteById(@Param("id") Long id, @Param("modifiedBy") String modifiedBy, @Param("modifiedDate") LocalDateTime modifiedDate);

}