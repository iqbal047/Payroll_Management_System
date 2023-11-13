package com.prologiccreations.traderssolution.dao.super_classes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudDao<T, I> {

    Page<T> findByActive(boolean isActive, Pageable pageable);
}
