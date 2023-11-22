package com.prologiccreations.payrollapplication.service.super_classes.config;

import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Department;
import com.prologiccreations.payrollapplication.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService extends CrudService<Department, Long> {

    Response storeData(Department data);

    Response<Page<Department>> getAll(Pageable pageable);

    Response<Department> getById(Long id);

    Response delete(Long id);

    String validate(Department data);

    String checkDuplicate(Department data);
}
