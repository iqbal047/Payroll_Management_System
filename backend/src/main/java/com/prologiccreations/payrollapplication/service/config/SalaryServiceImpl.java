package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.SalaryRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Salary;
import com.prologiccreations.payrollapplication.service.super_classes.config.SalaryService;
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
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository repository;

    @Override
    public Response storeData(Salary data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Salary>> getAll(Pageable pageable) {
        Page<Salary> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Salary> getById(Long id) {
        Salary salary = repository.findById(id).orElse(new Salary());
        return new Response<>(SUCCESS, null, salary);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Salary data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Salary data) {
//        boolean salarynameExists;
//        if (data.hasId()) {
//            salarynameExists = repository.existsBySalaryname(data.getSalaryname(), data.getId());
//        } else {
//            salarynameExists = repository.existsBySalaryname(data.getSalaryname());
//        }
//        return salarynameExists ? "Failed to register. Salary already exists" : null;
        return null;
    }

}
