package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.Salary;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalaryService extends CrudService<Salary, Long> {

    Response storeData(Salary data);

    Response<Page<Salary>> getAll(Pageable pageable);

    Response<Salary> getById(Long id);

    Response delete(Long id);

    String validate(Salary data);

    String checkDuplicate(Salary data);
}
