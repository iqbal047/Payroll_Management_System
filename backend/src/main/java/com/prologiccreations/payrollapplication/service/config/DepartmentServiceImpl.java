package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.DepartmentRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Department;
import com.prologiccreations.payrollapplication.service.super_classes.config.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.prologiccreations.payrollapplication.PayrollApplication.getCurrentUsername;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public Response storeData(Department data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Department>> getAll(Pageable pageable) {
        Page<Department> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Department> getById(Long id) {
        Department department = repository.findById(id).orElse(new Department());
        return new Response<>(SUCCESS, null, department);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Department data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Department data) {
//        boolean departmentnameExists;
//        if (data.hasId()) {
//            departmentnameExists = repository.existsByDepartmentname(data.getDepartmentname(), data.getId());
//        } else {
//            departmentnameExists = repository.existsByDepartmentname(data.getDepartmentname());
//        }
//        return departmentnameExists ? "Failed to register. Department already exists" : null;
        return null;
    }

}
