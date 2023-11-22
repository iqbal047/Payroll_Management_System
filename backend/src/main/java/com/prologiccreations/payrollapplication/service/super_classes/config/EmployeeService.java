package com.prologiccreations.payrollapplication.service.super_classes.config;

import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Employee;
import com.prologiccreations.payrollapplication.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService extends CrudService<Employee, Long> {

    Response storeData(Employee data);

    Response<Page<Employee>> getAll(Pageable pageable);

    Response<Employee> getById(Long id);

    Response delete(Long id);

    String validate(Employee data);

    String checkDuplicate(Employee data);
}
